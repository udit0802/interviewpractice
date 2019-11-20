package prac.dp;

public class DecodeMessageProblem {

	private static int decodeMessage(String str) {
		int[] ways = new int[str.length()+1];
		for(int i = 0;i < ways.length;i++)
			ways[i] = -1;
		return decodeMessageUtil(str.toCharArray(),str.length(),ways);
	}

	private static int decodeMessageUtil(char[] charArray, int lengthToConsider, int[] ways) {
		if(0 == lengthToConsider) {
			ways[lengthToConsider] = 1;
			return 1;
		}
		int s = charArray.length - lengthToConsider;
		if(charArray[s] == '0')
			return 0;
		if(ways[lengthToConsider] != -1) {
			return ways[lengthToConsider];
		}
		int result = decodeMessageUtil(charArray, lengthToConsider - 1, ways);
		if(lengthToConsider >= 2 && Integer.parseInt(new String(charArray,s,2)) <= 26)
			result += decodeMessageUtil(charArray, lengthToConsider - 2, ways);
		ways[lengthToConsider] = result;
		return result;
	}
	
	public static void main(String[] args) {
		String test = "1234";
		System.out.println(decodeMessage(test));
	}
}
