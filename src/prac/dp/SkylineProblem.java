package prac.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SkylineProblem {
	
	//this uses priority queue for maintaing the max height till
	//total points to process is 2*no. of buildings (i.e start and end)
	//In java Tree Map is an implementation of priority queue that supports insert delete and max/min operations in O(logn) 
	
	//Tie breaker rules:
	/*
	 * 1. If start of 2 buildings start at same point that choose the building having greater height first
	 * 
	 * 2. If end of 2 buildings end at same point than choose building having lower height first
	 * 
	 * 3. If end of 1 building coincide with start of next building than choose start before end
	 * */
	
	static class Building implements Comparable<Building>{
		int x;
		
		boolean start;
		
		int height;
		
		@Override
		public String toString() {
			return "Building [x=" + x + ", start=" + start + ", height=" + height + "]";
		}

		@Override
		public int compareTo(Building o) {
			if(this.x != o.x) {
				return this.x - o.x;
			}else {
				return (this.start?-this.height : this.height) - (o.start?-o.height : o.height);
			}
		}
		
	}
	
	private static List<int[]> skyline(int[][] buildings) {
		Building[] points = new Building[buildings.length * 2];
		int index = 0;
		for(int[] building : buildings) {
			points[index] = new Building();
			points[index].x = building[0];
			points[index].start = true;
			points[index].height = building[2];
			
			
			points[index+1] = new Building();
			points[index+1].x = building[1];
			points[index+1].start = false;
			points[index+1].height = building[2];
			
			index += 2;
		}
		Arrays.sort(points);
		for(Building inter : points) {
			System.out.println(inter);
		}
		//for logn operations
		TreeMap<Integer, Integer> queue = new TreeMap<>();
		//key is height and value is count of height
		queue.put(0, 1);
		int maxPrev = 0;
		
		List<int[]> result = new ArrayList<>();
		for(Building point : points) {
			
			if(point.start) {
				queue.compute(point.height, (key,value) ->{
					if(value != null)
						return value + 1;
					return 1;
				});
			}else {
				queue.compute(point.height, (key,value) ->{
					if(value == 1)
						return null;
					return value -1;
				});
			}
			
			int currentHeight = queue.lastKey();
			if(currentHeight != maxPrev) {
				result.add(new int[] {point.x,currentHeight});
				maxPrev = currentHeight;
			}
			
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] buildings = {{1,3,4},{3,4,4},{2,6,2},{8,11,4},{7,9,3},{10,11,2}};
		
		List<int[]> skylineView = skyline(buildings);
		skylineView.stream().forEach(p->System.out.println("{" + p[0] + "," + p[1] + "}"));
	}
}
