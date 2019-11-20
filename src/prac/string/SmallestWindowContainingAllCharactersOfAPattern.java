package prac.string;

public class SmallestWindowContainingAllCharactersOfAPattern {

	static int no_of_char = 256;
	
	public static String subStringcontainedInPattern(String pat,String input) {
		
		if(null == pat || null == input)
			return "invalid input";
		
		int lenPat = pat.length();
		int lenStr = input.length();
		
		int hash_pat[] = new int[no_of_char];
		int hash_str[] = new int[no_of_char];
		
		if(lenStr < lenPat)
			return "No such window exists";
		
		for(int i = 0; i< lenPat;i++) {
			hash_pat[pat.charAt(i)]++;
		}
		
		int count = 0,start = 0,start_index = -1;
		int min_len = Integer.MAX_VALUE;
		
		for(int j = 0; j < lenStr; j++) {
			
			hash_str[input.charAt(j)]++;
			
			if(hash_pat[input.charAt(j)] != 0 && hash_str[input.charAt(j)] <= hash_pat[input.charAt(j)])
				count++;
			if(count == lenPat) {
				
				while(hash_str[input.charAt(start)] > hash_pat[input.charAt(start)] || hash_pat[input.charAt(start)] == 0) {
					
					if(hash_str[input.charAt(start)] > hash_pat[input.charAt(start)])
						hash_str[input.charAt(start)]--;
					start++;
				}
				int len_window = j - start + 1;
				if(min_len > len_window) {
					min_len = len_window;
					start_index = start;
				}
			}
			
		}
		
		if(start_index == -1)
			return "No such window exists!!";
		return input.substring(start_index, start_index + min_len);
	}
	
	
	public static void main(String[] args) {
		String input = "this is a test string";
		String pat = "tist";
		
		String testI = "abcd";
		String testP = "abcd";
		
		System.out.println(subStringcontainedInPattern(pat, input));
		
		System.out.println(subStringcontainedInPattern(testP, testI));
	}
}
