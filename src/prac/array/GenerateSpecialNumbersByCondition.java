package prac.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GenerateSpecialNumbersByCondition {
	
	List<String> ans = new ArrayList<>();

	void generateAndCount() {
		
		Queue<String> q = new LinkedList<>();
		q.add("1");
		q.add("2");
		q.add("3");
		q.add("4");
		q.add("5");
		
		ans.add("0");
		
		while(!q.isEmpty()) {
			
			String num = q.poll();
			if(isValid(num))
				ans.add(num);
			
			if(num.length() > 5)
				continue;
			
			for(Integer i = 0; i <= 5;i++) {
				
				String z = i.toString();
				q.add(num + z);
				
			}
			
		}
		
		
	}
	
	boolean isSafe(int l,int r,String inp) {
		
		int number = Integer.parseInt(inp);
		return number >= l && number <= r;
		
	}
	
	private int findCount(int l,int r) {
		int count = 0;
		generateAndCount();
		for(int i = 0;i < ans.size();i++) {
			
			if(isSafe(l,r,ans.get(i))) {
				System.out.println(ans.get(i));
				count++;
			}
				
		}
		
		return count;
	}

	private boolean isValid(String num) {
		Map<Integer,Integer> foundMap = new HashMap<>();
		char[] chars = num.toCharArray();
		for(int i = 0;i < chars.length;i++) {
			
			if(foundMap.containsKey(chars[i]-'0'))
				return false;
			else if(chars[i] - '0' > 5)
				return false;
			foundMap.put(chars[i]-'0', 1);
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		GenerateSpecialNumbersByCondition sp = new GenerateSpecialNumbersByCondition();
		System.out.println(sp.findCount(1, 1000));
		
	}
}
