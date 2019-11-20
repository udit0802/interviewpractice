package prac.dp;

public class RainDroppingProblem {
	
	private static int waterAmount(int...watertowers) {
		int len = watertowers.length;
		if(len == 0)
			return 0;
		int l = 0,r = len-1, ans = 0;
		int lmax = 0,rmax = 0;
		while (l < r) {
			if(watertowers[l] < watertowers[r]) {
				if(watertowers[l] > lmax) {
					lmax = watertowers[l];
				}else {
					ans += (lmax - watertowers[l]);
				}
				l++;
			}else {
				if(watertowers[r] > rmax) {
					rmax = watertowers[r];
				}else {
					ans += (rmax - watertowers[r]);
				}
				r--;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] input = {7,3,4,8,2,0,5};
		System.out.println(waterAmount(input));
		
		int[] input2 = {1,2,3,4,5,6};
		System.out.println(waterAmount(input2));
	}
}
