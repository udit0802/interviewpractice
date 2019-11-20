package prac.string;

public class RecursivelyRemoveAllAdjacentDuplicates {

	
	private String remove(String s,char lastRemoved) {
		
		if(s.length() == 0 || s.length() == 1)
			return s;
		
		if(s.charAt(0) == s.charAt(1)) {
			
			lastRemoved = s.charAt(0);
			while(s.length() > 1 && s.charAt(0) == s.charAt(1)) {
				s = s.substring(1, s.length());
			}
			s = s.substring(1, s.length());
			return remove(s, lastRemoved);
		}
		
		
		String rem = remove(s.substring(1,s.length()), lastRemoved);
		
		if(rem.length() > 0 && rem.charAt(0) == s.charAt(0)) {
			lastRemoved = s.charAt(0);
			return rem.substring(1,rem.length());
		}
		else if(rem.length() == 0 && lastRemoved == s.charAt(0)) {
			return rem;
		}
		return s.charAt(0) + rem;
	}
	
	
	public static void main(String[] args) {
		RecursivelyRemoveAllAdjacentDuplicates r = new RecursivelyRemoveAllAdjacentDuplicates();
		System.out.println(r.remove("acbbcddc", '\0'));
		System.out.println(r.remove("caaabbbaacdddd", '\0'));
	}
}
