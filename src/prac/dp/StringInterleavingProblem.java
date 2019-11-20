package prac.dp;

public class StringInterleavingProblem {

	/*
	 * Given two strings and another input string we need to find whether input string
	 * is an interleaving of given two strings
	 * 
	 * By interleaving we mean that characters of both strings are present in the input string
	 * along with the order is maintained
	 * 
	 * */
	
	private static boolean isInterleaving(char[] pat1,char[] pat2,char[] input) {
		if(pat1.length + pat2.length != input.length)
			return false;
		boolean[][] check = new boolean[pat1.length+1][pat2.length+1];
		for(int i = 0;i < check.length;i++) {
			for(int j = 0; j < check[i].length;j++) {
				if(i == 0 && j == 0)
					check[0][0] = true;
				else if(i == 0) {
					if(input[i+j-1] == pat2[j-1])
						check[i][j] = check[i][j-1];
				}else if(j == 0) {
					if(input[i+j-1] == pat1[i-1])
						check[i][j] = check[i-1][j];
				}else {
					check[i][j] = (pat1[i-1] == input[i+j-1]?check[i-1][j]:false) || (pat2[j-1] == input[i+j-1]?check[i][j-1]:false);
				}
			}
		}
		return check[pat1.length][pat2.length];
	}
	
	
	public static void main(String[] args) {
		String str1 = "XXYM";
        String str2 = "XXZT";
        String str3 = "XXXZXYTM";
        
        System.out.println(isInterleaving(str1.toCharArray(), str2.toCharArray(), str3.toCharArray()));
	}
}
