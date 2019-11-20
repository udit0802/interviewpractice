package prac.array;

public class KadaneAlgorithm {

	private static int maxSum(int[] arr) {
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;
		boolean allneg = true;
		int max = arr[0];
		int start = 0;
		int end = 0;
		int s = 0;
		
		for(int i = 0;i < arr.length;i++) {
			if(allneg && arr[i] >= 0)
				allneg = false;
			max_ending_here += arr[i];
			if(max_ending_here < 0) {
				max_ending_here = 0;
				s = i+1;
			}
			else if(max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}
			if(allneg) {
				max = Math.max(max, arr[i]);
			}
				
		}
		if(!allneg) {
			System.out.println("Starting index " + start + " ,Ending index " + end);
			return max_so_far;
		}else {
			System.out.println("Array consist of all negative numbers so returning max number = " + max);
			return max;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {-3,-2};
		System.out.println(maxSum(arr));
	}
}
