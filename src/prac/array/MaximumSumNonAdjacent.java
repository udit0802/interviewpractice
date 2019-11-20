package prac.array;

public class MaximumSumNonAdjacent {

	private static int maximumSumNonAdjacent(int[] arr) {
		int incl = arr[0];
		int excl = 0;
		
		for(int i = 1; i < arr.length;i++) {
			int oldIncl = incl;
			incl = Math.max(incl, excl + arr[i]);
			excl = oldIncl;
		}
		return incl;
	}
	
	public static void main(String[] args) {
		int[] arr = {4,1,1,4,2,1};
		System.out.println(maximumSumNonAdjacent(arr));
	}
}
