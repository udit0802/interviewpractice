package prac.dp;

import java.util.Arrays;

public class BoxStackingProblem {

	static class Box implements Comparable<Box>{
		int l;
		int w;
		int h;
		
		public Box(int l, int w, int h) {
			super();
			this.l = l;
			this.w = w;
			this.h = h;
		}

		@Override
		public int compareTo(Box o) {
			return o.l*o.w - this.l*this.w;
		}
		
	}
	
	static int maxHeight(Box[] boxes) {
		Box[] allCombos = new Box[3*boxes.length];
		int index = 0;
		for(int i = 0;i< boxes.length;i++) {
			allCombos[index] = new Box(Math.max(boxes[i].l, boxes[i].w),Math.min(boxes[i].l, boxes[i].w),boxes[i].h);
			index++;
			allCombos[index] = new Box(Math.max(boxes[i].l, boxes[i].h), Math.min(boxes[i].l, boxes[i].h), boxes[i].w);
			index++;
			allCombos[index] = new Box(Math.max(boxes[i].w, boxes[i].h),Math.min(boxes[i].w, boxes[i].h),boxes[i].l);
			index++;
		}
		
		Arrays.sort(allCombos);
		for(Box box : allCombos) {
			System.out.println(box.l + "x" + box.w + "x" + box.h);
		}
		int mh[] = new int[allCombos.length];
		for(int i = 0 ;i < allCombos.length;i++) {
			mh[i] = allCombos[i].h;
		}
		int max = Integer.MIN_VALUE;
		for(int i = 1;i < allCombos.length;i++) {
			for(int j = 0;j < i;j++) {
				if(allCombos[i].w < allCombos[j].w && allCombos[i].l < allCombos[j].l && mh[i] < mh[j] + allCombos[i].h) {
					mh[i] = mh[j] + allCombos[i].h;
					if(max < mh[i])
						max = mh[i];
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		Box[] boxes = {new Box(4, 6, 7),new Box(1, 2, 3),new Box(4, 5, 6),new Box(10, 12, 32)};
		System.out.println(maxHeight(boxes));
	}
}
