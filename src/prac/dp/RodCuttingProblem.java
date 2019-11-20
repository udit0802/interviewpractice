package prac.dp;

public class RodCuttingProblem {

	int rodCutProfit(int[] profits,int length,int[] lengths) {
		
		int[][] dp = new int[profits.length + 1][length + 1];
		
		for(int i = 1;i <= profits.length;i++) {
			for(int j = 1;j <= length;j++) {
				
				if(lengths[i-1] > j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], profits[i-1] + dp[i][j-lengths[i-1]]);
				}
			}
		}
		return dp[profits.length][length];
	}
	
	public static void main(String[] args) {
		int[] profits = {2,5,7,8};
		int[] lengths = {1,2,3,4};
		int len = 5;
		RodCuttingProblem p = new RodCuttingProblem();
		System.out.println(p.rodCutProfit(profits, len, lengths));
	}
	
}
