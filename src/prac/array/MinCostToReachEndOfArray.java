package prac.array;

public class MinCostToReachEndOfArray {

	
	int minCost(int[] a,int k) {
		
		int n = a.length;
		int[] dp = new int[n];
		dp[n-1] = 0;
		for(int i = n-2;i >= 0;i--) {
			
			if(i + k >= n-1) {
				dp[i] = Math.abs(a[i]-a[n-1]);
			}
			else {
				int min = Integer.MAX_VALUE;
				for(int j = i+1;j <= i+k;j++) {
					int currVal = Math.abs(a[i]-a[j]) + dp[j];
					if(min > currVal)
						min = currVal;
				}
				dp[i] = min;
			}
		}
		
		return dp[0];
	}
	
	public static void main(String[] args) {
		MinCostToReachEndOfArray m = new MinCostToReachEndOfArray();
		int[] a = {83, 26, 37, 35, 33, 35, 56};
		int k = 3;
		System.out.println(m.minCost(a, k));
	}
}
