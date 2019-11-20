package prac.dp;

public class CoinChangeProblem {

	/*
	 * Given an infinite supply of coins of certain denominations and a sum
	 * find the minimum number of coins needed to make the sum
	 * */
	
	
	private static int count(int[] input,int sum,int[] result) {
		int[][] matrix = new int[input.length+1][sum+1];
		
		for(int i = 0;i <= sum;i++)
			matrix[0][i] = Integer.MAX_VALUE;
		
		for(int i = 1;i < matrix.length;i++) {
			for(int j = 1;j < matrix[i].length;j++) {
				if(j < input[i-1]) {
					matrix[i][j] = matrix[i-1][j];
				}else {
					matrix[i][j] = Math.min(matrix[i-1][j], 1+matrix[i][j-input[i-1]]);
				}
			}
		}
		int i = input.length;
		int j = sum;
		int k = 0;
		while(j != 0) {
			while(matrix[i][j] == matrix[i-1][j]) {
				i--;
			}
			result[k++] = input[i-1];
			j-=input[i-1];
			i--;
		}
		return matrix[input.length][sum];
	}
	
	public static void main(String[] args) {
		int[] input = {1,5,6,8,15};
		int[] result = new int[input.length];
		System.out.println("number of coins needed = " + count(input, 26,result));
		System.out.print("Denominations needed are = ");
		System.out.print("{");
		boolean start= true;
		for(int a:result) {
			if(a == 0)
				break;
			if(!start)
				System.out.print(",");
			start = false;
			System.out.print(a);
		}
		System.out.print("}");
	}
	
}
