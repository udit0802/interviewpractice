package prac.dp;

public class PalindromePartitionProblem {

	/*
	 * Minimum number of splits needed to make every part of string a palindrome 
	 * */
	
	private static boolean isPalindrome(String check) {
			int length = check.length();
			String reverse = "";
	      for (int i = length - 1; i >= 0; i--)
	         reverse = reverse + check.charAt(i);
	         
	      return check.equals(reverse);
	}
	
	private static int splits(String input) {
		if(isPalindrome(input))
			return 0;
		int[][] splits = new int[input.length()][input.length()];
		
		for(int l=2;l<=input.length();l++) {
			for(int i = 0;i<= splits.length-l;i++) {
				int j = i + l - 1;
				if(isPalindrome(input.substring(i, j+1)))
					splits[i][j] = 0;
				else {
					splits[i][j] = Integer.MAX_VALUE;
					for(int k = i; k < j; k++) {
						int val = 1 + splits[i][k] + splits[k+1][j];
						if(val < splits[i][j])
							splits[i][j] = val;
					}
				}
			}
		}
		return splits[0][input.length()-1];
	}
	
	public static void main(String[] args) {
		System.out.println(splits("abcbc"));
	}
}
