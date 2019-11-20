package prac.dp;

public class StaircaseGenericProblem {

	private static int numWays(int n,int[] allowedJumpValues) {
		if(0 == n)
			return 1;
		int[] ways = new int[n+1];
		ways[0] = 1;
		for(int i = 1;i <= n; i++) {
			int total = 0;
			for(int j : allowedJumpValues) {
				if(i - j >= 0)
					total += ways[i-j];
			}
			ways[i] = total;
		}
		return ways[n];
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[] allowedJumpValues = {1,3,5};
		System.out.println(numWays(n, allowedJumpValues));
	}
}
