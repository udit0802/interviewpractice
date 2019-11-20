package prac.linkedlist;

public class LinkedListPoductOfNodesBetween0 {

	class Node{
		
		int data;
		Node next;
		public Node(int data) {
			super();
			this.data = data;
			next = null;
		}
		
		
		
	}
	
	Node product(Node head) {
		
		if(null == head)
			return null;
		while(head.data == 0)head = head.next;
		Node curr = head;
		Node prev = null;
		while(true) {
			int product = 1;
			while(curr.data != 0 && curr != null) {
				prev = curr;
				product *= prev.data;
				curr = curr.next;
			}
			prev.data = product;
			if(null == curr)
				break;
			
			prev.next = curr.next;
			curr.next = null;
			curr = prev.next;
		}
		
		return head;
	}
	
}
