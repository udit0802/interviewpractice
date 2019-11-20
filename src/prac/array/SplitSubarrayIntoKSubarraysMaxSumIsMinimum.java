package prac.array;

public class SplitSubarrayIntoKSubarraysMaxSumIsMinimum {

	int solve(int[] arr,int k) {
		
		int start = 1;
		int end = 0;
		int ans = 0;
		int n = arr.length;
				;
		for(int i = 0; i< n;i++)
			end += arr[i];
		
		while(start <= end) {
			
			int mid = start + ((end - start) / 2);
			if(check(arr,n,k,mid)) {
				end = mid - 1;
				ans = mid;
			}else
				start = mid+1;
			
		}
		return ans;
	}

	private boolean check(int[] arr, int n, int k, int mid) {
		int count = 0;
		int sum = 0;
		int i = 0;
		while(i < n) {
			if(arr[i] > mid)
				return false;
			sum += arr[i];
			if(sum > mid) {
				count++;
				sum = arr[i];
			}
			i++;
		}
		
		if(count <= k)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {3,2,1,2,3};
		SplitSubarrayIntoKSubarraysMaxSumIsMinimum s = new SplitSubarrayIntoKSubarraysMaxSumIsMinimum();
		System.out.println(s.solve(arr, 2));
		
	}
	
}
