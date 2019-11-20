package prac.string;

public class KMP {

	int[] computePrefix(char[] pattern) {
		
		int[] prefix = new int[pattern.length];
		int j = 0;
		int i = 1;
		while(i < pattern.length) {
			
			if(pattern[i] == pattern[j]) {
				prefix[i] = j+1;
				i++;
				j++;
			}else {
				if(j > 0)
					j = prefix[j-1];
				else {
					prefix[i] = 0;
					j = 0;
					i++;
				}
					
			}
			
		}
		
		return prefix;
	}
	
	int findPatternInString(char[] text,char[] pattern) {
		
		int[] prefix = computePrefix(pattern);
		int i = 0;
		int j = 0;
		int count = 0;
		boolean found = false;
		while(true) {
			
			if(text[i] == pattern[j]) {
				i++;
				j++;
				if(j == pattern.length) {
					found = true;
					System.out.println("found pattern at index = " + (i - pattern.length));
					count++;
					j=prefix[j-1];
				}
			}else {
				if(j > 0) {
					j = prefix[j-1];
				}else {
					j = 0;
					i++;
				}
			}
			
			if(i == text.length) {
				if(!found)
					System.out.println("Not found");
				break;
			}
		}
		return count;
		
	}
	
	public static void main(String[] args) {
		String pattern = "abcabc";
		KMP kmp = new KMP();
		int[] res = kmp.computePrefix(pattern.toCharArray());
		for(int i = 0;i < res.length;i++)
			System.out.println(res[i]);
		
		String text = "abxabcabcabc";
		System.out.println(kmp.findPatternInString(text.toCharArray(), pattern.toCharArray()));
	}
}
