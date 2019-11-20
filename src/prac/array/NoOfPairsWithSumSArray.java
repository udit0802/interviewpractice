package prac.array;

import java.util.HashMap;
import java.util.Map;

public class NoOfPairsWithSumSArray {
	
	void rearrange(int[] arr) {
		
		int pivot = 10;
		int i = -1;
		int temp = 0;
		int n = arr.length;
		for(int j = 0;j < n;j++) {
			if(arr[j] < pivot) {
				++i;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		for(int k = 0;k < n;k++) {
			System.out.println(arr[k]);
		}
	}

	int pairs(int arr[],int sum) {
		
		int n = arr.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		for(int i = 0; i < n ;i++) {
			
			if(null == map.get(arr[i]))
				map.put(sum-arr[i], 1);
			else {
				count++;
				map.remove(arr[i]);
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		NoOfPairsWithSumSArray p = new NoOfPairsWithSumSArray();
		int arr[] = {3,4,5,6,10,1,2,4,11};
		System.out.println(p.pairs(arr, 7));
		
		p.rearrange(arr);
	}
}
