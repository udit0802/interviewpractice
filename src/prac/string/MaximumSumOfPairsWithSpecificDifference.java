package prac.string;

import java.util.Arrays;

public class MaximumSumOfPairsWithSpecificDifference {

	int sum(int[] arr,int k) {
		
		Arrays.sort(arr);
		int[] dp = new int[arr.length];
		for(int i = 1;i < arr.length;i++) {
			
			dp[i] = dp[i-1];
			if(arr[i] - arr[i-1] < k) {
				
				if(i >= 2) {
					dp[i] = Math.max(dp[i-2] + arr[i] + arr[i-1], dp[i]);
				}else {
					dp[i] = Math.max(dp[i], arr[i] + arr[i-1]);
				}
				
			}
			
		}
		
		return dp[arr.length-1];
		
	}
	
	
	public static void main(String[] args) {
		int arr[] = {3,5,10,15,17,12,9};
		MaximumSumOfPairsWithSpecificDifference m = new MaximumSumOfPairsWithSpecificDifference();
		int sum = m.sum(arr, 4);
		System.out.println(sum);
	}
}
