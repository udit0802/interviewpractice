package prac.dp;

import java.util.Arrays;

public class JobSchedulingProblem {
	
	static class Job implements Comparable<Job>{
		int start;
		
		int end;
		
		int profit;

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public int getProfit() {
			return profit;
		}

		public void setProfit(int profit) {
			this.profit = profit;
		}
		
		public Job(int start, int end, int profit) {
			super();
			this.start = start;
			this.end = end;
			this.profit = profit;
		}

		@Override
		public int compareTo(Job o) {
			return this.end - o.end;
		}
		
	}
	
	private static boolean donotOverlap(Job j1,Job j2) {
		if(j2.end <= j1.start)
			return true;
		return false;
	}

	private static int profit(Job[] input) {
		int[] cost = new int[input.length];
		int max = Integer.MIN_VALUE;
		Arrays.sort(input);
		for(int i = 0 ;i < input.length;i++) {
			cost[i] = input[i].profit;
		}
		for(int i = 1; i < input.length;i++) {
			for(int j = i-1 ; j >= 0;j--) {
				if(donotOverlap(input[i], input[j])) {
					cost[i] = Math.max(cost[i], cost[j]+input[i].profit);
					if(cost[i] > max)
						max = cost[i];
//					break;
				}
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		Job[] input = {new Job(4,6,5),new Job(2,5,6),new Job(6,7,4),new Job(7,9,2),new Job(5,8,11),new Job(1,3,5)};
		System.out.println(profit(input));
	}
}
