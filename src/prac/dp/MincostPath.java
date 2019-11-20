package prac.dp;

public class MincostPath {

	int minCost(int[][] cost) {
		int[][] dp = new int[cost.length][cost[0].length];
		int n = cost.length;
		dp[0][0] = cost[0][0];
		for(int i = 1; i < n;i++)
			dp[0][i] = dp[0][i-1] + cost[0][i];
		for(int j = 1;j < n;j++)
			dp[j][0] = dp[j-1][0] + cost[j][0];
		
		for(int i = 1;i <n;i++) {
			for(int j = 1;j <n;j++) {
				
				dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + cost[i][j];
				
			}
		}
		return dp[n-1][n-1];
	}

	int maxPath(int[][] cost) {
		int n = cost.length;
		int[][] dp = new int[n][n];
		dp[0][0] = cost[0][0];
		for(int j = 1;j < n;j++)
			dp[j][0] = dp[j-1][0] + cost[j][0];
		
		for(int i = 1; i< n;i++) {
			
			for(int j = 1;j < n;j++) {
				
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i][j-1]) + cost[i][j];
				
			}
			
		}
		return dp[n-1][n-1];
	}
	
	public static void main(String[] args) {
		int[][] cost = {{1,2,3},{4,8,2},{1,5,3}};
		MincostPath path = new MincostPath();
		System.out.println(path.minCost(cost));
		System.out.println(path.maxPath(cost));
		
	}
}
