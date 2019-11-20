package prac.array;

public class PowerFunc {

	
	int pow(int a,int b) {
		
		if(b == 0)
			return 1;
		int temp = pow(a,b/2);
		
		if(b % 2 == 0)
			return temp * temp;
		return a *temp*temp;
		
	}
	
	int powIter(int a,int b) {
		
		int res = 1;
		
		while(b != 0) {
			
			if(b%2 != 0)
				res *= a;
			
			b>>=1;
			a *= a;
			
		}
		
		return res;
		
	}
	
	public static void main(String[] args) {
		
		int a = 5,b=3;
		PowerFunc p = new PowerFunc();
		System.out.println(p.pow(a, b));
		
	}
}
