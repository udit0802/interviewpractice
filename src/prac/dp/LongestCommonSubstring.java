package prac.dp;

public class LongestCommonSubstring {

	private static int lengthofLCS(char[] str1,char[] str2) {
		
		int[][] matrix = new int[str1.length+1][str2.length+1];
		int len = 0;
		for(int i = 1;i <= matrix.length;i++) {
			for(int j = 1;j <= matrix[i].length;j++) {
				if(str1[i-1] == str2[j-1]) {
					matrix[i][j] = 1 + matrix[i-1][j-1];
					if(matrix[i][j] > len)
						len = matrix[i][j];
					//here also store the cell address
				}
			}
		}
		
		// to get the substring move diagonally top left till encounter 0 from the cell containing the max length
		return len;
	}
	
	public static void main(String[] args) {
		String str1 = "abcdaf";
		String str2 = "zbcdf";
		
		System.out.println(lengthofLCS(str1.toCharArray(), str2.toCharArray()));
	}
}
