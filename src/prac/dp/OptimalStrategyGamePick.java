package prac.dp;

public class OptimalStrategyGamePick {
	
	static class Score{
		int first;
		
		int second;
		
	}
	
	private static Score bestScore(int[] points) {
		Score[][] moves = new Score[points.length][points.length];
		
		for(int i = 0; i < points.length;i++) {
			moves[i][i] = new Score();
			moves[i][i].first = points[i];
			moves[i][i].second = 0;
		}
		
		for(int l = 2;l <= points.length;l++) {
			for(int i = 0; i <= moves.length - l;i++) {
				int j = i + l - 1;
				int val1 = points[i]+moves[i+1][j].second;
				int val2 = points[j]+moves[i][j-1].second;
				moves[i][j] = new Score();
				if(val1 > val2) {
					moves[i][j].first = val1;
					moves[i][j].second = moves[i+1][j].first;
				}else {
					moves[i][j].first = val2;
					moves[i][j].second = moves[i][j-1].first;
				}
				
			}
		}
		return moves[0][points.length-1];
	}

	public static void main(String[] args) {
		int[] points = {3,9,1,8};
		Score optimal = bestScore(points);
		System.out.println("Player 1 gets " + optimal.first);
		System.out.println("Player 2 gets " + optimal.second);
	}

}
