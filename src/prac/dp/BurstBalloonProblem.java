package prac.dp;

public class BurstBalloonProblem {

	private static int burstBalloonVal(int[] balloons) {
		int[][] values = new int[balloons.length][balloons.length];
		
		for(int l = 1; l <= balloons.length;l++) {
			for(int i = 0; i <= balloons.length - l;i++) {
				int j = i + l - 1;
				
				for(int k = i; k <= j;k++) {
					
					int leftval = 1;
					int rightval = 1;
					
					if(i != 0)
						leftval = balloons[i-1];
					if(j != balloons.length-1)
						rightval = balloons[j+1];
					
					int beforeVal = 0;
					int afterVal = 0;
					
					if(k != i)
						beforeVal = values[i][k-1];
					if(k != j)
						afterVal = values[k+1][j];
					
					values[i][j] = Math.max(leftval * balloons[k] * rightval + beforeVal + afterVal, values[i][j]);
					
				}
			}
		}
		
		return values[0][balloons.length-1];
	}
	
	public static void main(String[] args) {
		int[] balloons = {2,4,3,5};
		System.out.println(burstBalloonVal(balloons));
	}
}
