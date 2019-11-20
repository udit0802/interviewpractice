package prac.array;

import java.util.Stack;

public class LargestRectangleInHistogramProblem {

	private static int maxArea(int[] histogram) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		int max = Integer.MIN_VALUE;
		while(i < histogram.length) {
			if(stack.isEmpty() || histogram[stack.peek()] <= histogram[i]) {
				stack.push(i);
				i++;
			}else {
				int currMax = stack.pop();
				int bound = stack.isEmpty()?i:i - 1 - stack.peek();
				int area = histogram[currMax] * bound;
				if(area > max)
					max = area;
			}
		}
		while(!stack.isEmpty()) {
			int currMax = stack.pop();
			int bound = stack.isEmpty()?i:i - 1 - stack.peek();
			int area = histogram[currMax] * bound;
			if(area > max)
				max = area;
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		int[] hist = {1,2,3,4,5,3,3,2};
		System.out.println(maxArea(hist));
	}
}
