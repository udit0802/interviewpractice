package prac.string;

public class CompressStringAmazon {

	char[] compress(char[] str,int len,int act) {
		
		if(len < str.length) {
			
			
			int k = len;
			int count = 0;
			while(len < str.length && str[k] == str[len]) {
				len++;
				count++;
			}
			
			int n = 0;
			int c = count;
			while(c != 0) {
				c = c/10;
				n++;
			}
			
			compress(str, len, act + n + 1);
			
			str[act] = str[k];
			if(k + count == str.length)
				str[act + n + 1] = '\0';
			while(n > 0) {
				char ch=(char)(count %10+'0');   
				str[act + n] = ch ;
				count = count/10;
				n--;
			}
		}
		return str;
		
	}
	
	public static void main(String[] args) {
		String test = "aaabbccc";
		CompressStringAmazon csa = new CompressStringAmazon();
		char[] chars = csa.compress(test.toCharArray(), 0, 0);
		int i = 0;
		while(chars[i] != '\0')
			System.out.print(chars[i++]);
	}
}
