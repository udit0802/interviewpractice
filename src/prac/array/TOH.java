package prac.array;

import java.util.EmptyStackException;
import java.util.Stack;

public class TOH {

	
	public static void tohRecursive(int n,char from,char to,char aux) {
		
		
		if(n == 1) {
			System.out.println("move disk number = 1 from rod = " + from + " to rod = " + to);
			return;
		}
		
		tohRecursive(n-1, from, aux, to);
		
		System.out.println("move disk number = "+ n + " from rod = " + from + " to rod = " + to);
		
		tohRecursive(n-1, aux, to, from);
		
	}
	
	public static void tohIterative(int n) {
		
		char s = 'S',a = 'A',d = 'D';
		if(n <= 0)
			throw new IllegalArgumentException("Invalid input!!");
		
		if(n == 1) {
			System.out.println("move disk number = 1 from rod = " + s + " to rod = " + d);
			return;
		}
		
		Stack<Integer> from = new Stack<>();
		Stack<Integer> to = new Stack<>();
		Stack<Integer> aux = new Stack<>();
		
		if(n % 2 == 0) {
			char temp;
			temp = a;
			a = d;
			d = temp;
		}
		
		double movesReq = Math.pow(2, n) - 1;
		int moves = (int) movesReq;
		
		for(int disks = n;disks >=1;disks--)
			from.push(disks);
		
		for(int move = 1;move <= moves; move++) {
			if(move %3 == 1) {
				moveDisksBetweenPoles(from,to,s,d);
			}else if(move %3 == 2) {
				moveDisksBetweenPoles(from,aux,s,a);
			}else {
				moveDisksBetweenPoles(aux,to,a,d);
			}
		}
	}
	
	private static void moveDisksBetweenPoles(Stack<Integer> from, Stack<Integer> to, char s, char d) {
		boolean emptySrc = false;
		boolean emptyDest = false;
		int fromStackElem = 0;
		int toStackElem = 0;
		try {
			fromStackElem = from.pop();
		}catch (EmptyStackException e) {
			emptySrc = true;
		}
		try {
			toStackElem = to.pop();
		}catch (EmptyStackException e) {
			emptyDest = true;
		}
		
		if(emptySrc && !emptyDest) {
			from.push(toStackElem);
			moveDisk(d,s,toStackElem);
		}else if(!emptySrc && emptyDest) {
			to.push(fromStackElem);
			moveDisk(s,d,fromStackElem);
		}else if(fromStackElem > toStackElem) {
			from.push(fromStackElem);
			from.push(toStackElem);
			moveDisk(d,s,toStackElem);
		}else {
			to.push(toStackElem);
			to.push(fromStackElem);
			moveDisk(s,d,fromStackElem);
		}
	}

	private static void moveDisk(char s, char d, int disk) {
		System.out.println("move disk number = " + disk + " from source rod = " + s + " to dest rod = " + d);
	}

	public static void main(String[] args) {
		//tohRecursive(4, 'S', 'D', 'A');
		
		tohIterative(10);
	}
}
