package prac.linkedlist;

public class CountOccurenceLinkedList {

	class Node{
		int val;
		Node next;
		
		Node(int val){
			this.val = val;
			next = null;
		}
	}
	
	Node push(Node head,int val) {
		if(null == head) {
			head = new Node(val);
			return head;
		}
		Node newNode = new Node(val);
		newNode.next = head;
		head = newNode;
		return head;
	}
	
	int countOccurence(Node head,int val) {
		
		if(null == head)
			return 0;
		if(head.val == val)
			return 1 + countOccurence(head.next, val);
		return countOccurence(head.next, val);
		
	}

	public static void main(String[] args) {
		CountOccurenceLinkedList c = new CountOccurenceLinkedList();
		Node head = null;
		head = c.push(head, 1);
		head = c.push(head, 3);
		head = c.push(head, 1);
		head = c.push(head, 2);
		head = c.push(head, 1);
		System.out.println(c.countOccurence(head, 1));
	}
	
}
