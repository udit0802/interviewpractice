package prac.dp;

public class LongestPalindromicSubsequenceProblem {

	private static int length(char[] input) {
		int[][] matrix = new int[input.length][input.length];
		
		for(int i = 0;i < input.length;i++) {
			matrix[i][i] = 1;
		}
		
		for(int l = 2; l <= input.length;l++) {
			for(int i = 0;i <= input.length-l;i++) {
				int j = i + l - 1;
				if(input[i] != input[j]) {
					matrix[i][j] = Math.max(matrix[i][j-1], matrix[i+1][j]);
				}else {
					matrix[i][j] = 2 + matrix[i+1][j-1];
				}
			}
		}
		boolean odd = false;
		int i = 0;
		int j = input.length - 1;
		int k = 0;
		char[] result = new char[input.length];
		while(matrix[i][j] != 0 || matrix[i][j] != 1 && i <= j) {
			if(matrix[i+1][j-1] + 2 == matrix[i][j]) {
				result[k++] = input[j];
				i++;
				j--;
			}else if(matrix[i+1][j] == matrix[i][j]) {
				i++;
			}else {
				j--;
			}
			if(matrix[i][j] == 1) {
				odd = true;
				break;
			}
		}
		if(odd)
			result[k] = input[j];
		i = 0;
		System.out.print("Longest Palindromic subsequence is ");
		if(odd) {
			while( i <= k) {
				System.out.print(result[i]);
				i++;
			}
			i = i - 2;
			while(i >= 0) {
				System.out.print(result[i]);
				i--;
			}
		}else {
			while( i <= k) {
				System.out.print(result[i]);
				i++;
			}
			i = i - 1;
			while(i >= 0) {
				System.out.print(result[i]);
				i--;
			}
		}
		System.out.println();
		return matrix[0][input.length-1];
	}
	
	public static void main(String[] args) {
		String str = "agbdba";
//		String str = "agbbga";
		System.out.println("Length of longest palindromic subsequence = " + length(str.toCharArray()));
	}
}
