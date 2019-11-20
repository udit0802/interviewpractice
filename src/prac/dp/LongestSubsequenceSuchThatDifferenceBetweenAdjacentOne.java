package prac.dp;

public class LongestSubsequenceSuchThatDifferenceBetweenAdjacentOne {

	int longestSubsequence(int[] arr) {
		
		int[] dp = new int[arr.length];
		for(int i = 0;i < arr.length;i++)
			dp[i] = 1;
		
		
		for(int i = 1;i < arr.length;i++) {
			for(int j = 0;j < i;j++) {
				if(arr[i] == arr[j] + 1 || arr[i] == arr[j] - 1) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++)
			if(max < dp[i])
				max = dp[i];
		
		return max;
	}
	
	
}
