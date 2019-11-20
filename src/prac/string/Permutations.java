package prac.string;

import java.util.Map;
import java.util.TreeMap;

public class Permutations {
	
	private static int count = 0;

	private static void permute(String input) {
		char[] inputArr = input.toCharArray();
		Map<Character,Integer> countMap = new TreeMap<>();
		for(char c : inputArr) {
			countMap.compute(c, (key,value)->{
				if(null == value) {
					return 1;
				}else {
					return value + 1;
				}
			});
		}
		
		char[] characterArray = new char[countMap.size()];
		int[] countArray = new int[countMap.size()];
		int i = 0;
		for(Map.Entry<Character, Integer> entry : countMap.entrySet()) {
			characterArray[i] = entry.getKey();
			countArray[i] = entry.getValue();
			i++;
		}
		
		char[] result = new char[inputArr.length];
		
		permuteUtil(characterArray,countArray,result,0);
	}

	private static void permuteUtil(char[] characterArray, int[] countArray, char[] result, int i) {
		if( i == result.length) {
			for(char ch : result)
				System.out.print(ch);
			count++;
			System.out.println();
		}
		
		for(int iter = 0;iter < characterArray.length;iter++) {
			if(countArray[iter] == 0) {
				continue;
			}
			result[i] = characterArray[iter];
			countArray[iter]--;
			permuteUtil(characterArray, countArray, result, i+1);
			countArray[iter]++;
			
		}
		
	}
	
	public static void main(String[] args) {
		String input = "aabcd";
		permute(input);
		System.out.println(count);
	}
}
