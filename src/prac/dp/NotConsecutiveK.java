package prac.dp;

public class NotConsecutiveK {

	int no3areconsecutive(int arr[]) {
		
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = arr[0] + arr[1];
		dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2],arr[1]+arr[2]));
		for(int i = 3;i < arr.length;i++) {
			
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1]+arr[i]));
			
		}
		
		return dp[arr.length-1];
	}
	
	int no2consecutive(int[] arr) {
		
		int incl = arr[0];
		int excl = 0;
		int excl_new = 0;
		for(int i = 1;i <arr.length;i++) {
			
			excl_new= Math.max(incl, excl);
			incl = excl + arr[i];
			excl = excl_new;
		}
		
		return incl;
		
	}
	
	public static void main(String[] args) {
		int[] arr = {3000,2000,1000,3,10};
		NotConsecutiveK nck = new NotConsecutiveK();
		System.out.println(nck.no3areconsecutive(arr));
		System.out.println(nck.no2consecutive(arr));
	}
}
