package prac.dp;

import java.util.Stack;

public class BuySellStockProblem {
	
	/*
	 * Time complexity - O(days * transactions)
	 * Space complexity - O(days * transactions)
	 * 
	 * and transactions can never be greater than no. of days
	 * */

	public static int maxProfit(int[] prices,int k) {
		int[][] cost = new int[k+1][prices.length];
		for(int i=1;i<cost.length;i++) {
			int maxdiff = cost[i-1][0]-prices[0];
			for(int j=1;j<cost[i].length;j++) {
				cost[i][j] = Math.max(cost[i][j-1], maxdiff+prices[j]);
				maxdiff = Math.max(maxdiff, cost[i-1][j]-prices[j]);
			}
		}
		printActualOrder(cost,prices);
		return cost[k][prices.length-1];
	}

	private static void printActualOrder(int[][] cost, int[] prices) {
		int i = cost.length-1;
		int j = cost[0].length-1;
		
		Stack<Integer> stack = new Stack<>();
		
		while(true) {
			if(i == 0 || j == 0)
				break;
			if(cost[i][j] == cost[i][j-1])
				j = j-1;
			else {
				stack.push(j);
				int diff = cost[i][j] - prices[j];
				for(int k=j-1;k>=0;k--) {
					if(cost[i-1][k]-prices[k] == diff) {
						i = i-1;
						j = k;
						stack.push(j);
						break;
					}
				}
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.println("Buy at price -" + prices[stack.pop()]);
			System.out.println("Sell at price " + prices[stack.pop()]);
		}
		
	}
	
	public static void main(String[] args) {
		int prices[] = {2,5,7,1,4,3,1,3};
		System.out.println(maxProfit(prices, 3));
	}
}
