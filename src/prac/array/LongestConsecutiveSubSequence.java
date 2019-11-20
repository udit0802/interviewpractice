package prac.array;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSubSequence {

	int lengthOfLongestConsecutiveSubsequence(int[] arr) {
		
		Map<Integer,Boolean> map = new HashMap<>();
		for(int i = 0;i < arr.length;i++) {
			map.compute(arr[i], (key,value) -> {
				return true;
			});
		}
		int longest = Integer.MIN_VALUE;
		for(Map.Entry<Integer, Boolean> entry : map.entrySet()) {
			int key = entry.getKey();
			if(null == map.get(key-1)) {
				int curr = key;
				int count = 1;
				while(null != map.get(curr+1)) {
					count++;
					curr++;
				}
				longest = Math.max(longest, count);
			}
			
		}
		
		return longest;
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {3,8,10,1,9,6,5,7,2};
		LongestConsecutiveSubSequence l = new LongestConsecutiveSubSequence();
		System.out.println(l.lengthOfLongestConsecutiveSubsequence(arr));
		
	}
}
