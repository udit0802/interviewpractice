package prac.dp;

public class EggDroppingProblem {

	/*
	 * given a certain number of floors and eggs find the minimum number of attempts
	 * required to find out where the egg breaks
	 * 
	 * 
	 * */
	
	private static int minAttempts(int floors,int eggs) {
		int[][] cost = new int[eggs+1][floors+1];
		for(int i = 0;i <= floors;i++) {
			cost[1][i] = i;
		}
		int c = 0;
		for(int i=2;i<=eggs;i++) {
			for(int j = 1;j<=floors;j++) {
				if(j<i)
					cost[i][j] = cost[i-1][j];
				else {
					cost[i][j] = Integer.MAX_VALUE;
					for(int k = 1;k<=j;k++) {
						c = 1 + Math.max(cost[i-1][k-1], cost[i][j-k]);
						if(c < cost[i][j]) {
							cost[i][j] = c;
						}
					}
				}
			}
		}
		return cost[eggs][floors];
	}
	
	public static void main(String[] args) {
		System.out.println(minAttempts(100, 3));
	}
}
