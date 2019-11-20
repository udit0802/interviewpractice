package prac.linkedlist;

public class MergeSortedList {

	class Node{
		int val;
		Node next;
		
		Node(int val){
			this.val = val;
			next = null;
		}
	}
	
	Node sortedMergeDummy(Node a,Node b) {
		Node tail = new Node(0);
		Node dummy = tail;
		
		while(null != a && null != b) {
			if(a.val <= b.val) {
				dummy.next = a;
				a = a.next;
			}else {
				dummy.next = b;
				b = b.next;
			}
			dummy = dummy.next;
		}
		if(null == a)
			dummy.next = b;
		if(null == b)
			dummy.next = a;
		
//		short s1 = 42;
//		short s2 = 34;
//		short s3 = s1 + s2;
		
		return tail.next;
		
		
		
	}
	
	
	Node mergeList(Node a,Node b) {
		
		if(null == a)
			return b;
		if(null == b)
			return a;
		if(a.val <= b.val) {
			a.next = mergeList(a.next, b);
			return a;
		}else {
			b.next = mergeList(a, b.next);
			return b;
		}
	}
	
}
