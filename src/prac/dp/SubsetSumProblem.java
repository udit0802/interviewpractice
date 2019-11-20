package prac.dp;

public class SubsetSumProblem {

	private static boolean sumPresent(int[] input,int sum,int[] result) {
		boolean[][] matrix = new boolean[input.length+1][sum+1];
		
		for(int i = 0; i< input.length;i++) {
			matrix[i][0] = true;
		}
		
		for(int i = 1;i < matrix.length;i++) {
			for(int j = 1;j < matrix[i].length;j++) {
				if(j < input[i-1]) {
					matrix[i][j] = matrix[i-1][j];
				}else {
					matrix[i][j] = matrix[i-1][j] || matrix[i-1][j-input[i-1]];
				}
			}
		}
		if(matrix[input.length][sum]) {
			int i = input.length;
			int j = sum;
			int k = 0;
			while(j != 0) {
				while(matrix[i-1][j]) {
					i--;
				}
				result[k++] = input[i-1];
				j-=input[i-1];
				i--;
			}
		}
		return matrix[input.length][sum];
	}
	
	public static void main(String[] args) {
		int[] input = {2,3,8,7,10};
		int[] result = new int[input.length];
		if(sumPresent(input, 11,result)) {
			System.out.println("Yes");
			System.out.println("Subset is...");
			System.out.print("{");
			boolean start = true;
			for(int a:result) {
				if(a == 0)
					break;
				if(!start)
					System.out.print(",");
				start = false;
				System.out.print(a);
			}
			System.out.println("}");
		}
		else
			System.out.println("No");
	}
}
