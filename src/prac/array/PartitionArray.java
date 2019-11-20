package prac.array;

//S(n+1,k) = S(n,k-1) + k * S(n,k)

public class PartitionArray {

	int partitionKSubsets(int n,int k) {
		
		if(n < k)
			return 0;
		
		int[][] dp = new int[n+1][k+1];
		
		for(int i = 1;i <= n;i++) {
			
			for(int j = 1;j <= k;j++) {
				
				if(j == 1 || j == i)
					dp[i][j] = 1;
				else {
					dp[i][j] = dp[i-1][j-1] + j * dp[i-1][j];
				}
			}
			
		}
		
		return dp[n][k];
		
	}
	
	public static void main(String[] args) {
		PartitionArray a = new PartitionArray();
		System.out.println(a.partitionKSubsets(5, 2));
	}
}
