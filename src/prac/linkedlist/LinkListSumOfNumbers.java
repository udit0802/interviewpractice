package prac.linkedlist;

public class LinkListSumOfNumbers {

	class Node{
		
		private int val;
		private Node next;
		
		public Node(int value) {
			val = value;
			next = null;
		}
		
	}
	
	private Node result;
	int carry = 0;
	Node curr;
	
	private int size(Node head) {
		if(null == head)
			return 0;
		return 1 + size(head.next);
	}
	
	private void addList(Node head1,Node head2) {
		
		if(null == head1) {
			result = head2;
			return ;
		}else if(null == head2) {
			result = head1;
			return ;
		}
		int size1 = size(head1);
		int size2 = size(head2);
		if(size1 == size2)
			addListSameSize(head1,head2);
		else {
			
			if(size1 < size2) {
				Node temp = head1;
				head1 = head2;
				head2 = temp;
			}
			
			int diff = Math.abs(size1-size2);
			Node temp = head1;
			while(diff-- >= 0) {
				curr = temp;
				temp = temp.next;
			}
			addListSameSize(curr,head2);
			propogateCarry(head1);
			
			
			if(carry > 0) {
				Node newNode = new Node(carry);
				newNode.next = result;
				result = newNode;
			}
			
		}
		
		
	}
	
	private void propogateCarry(Node head) {
		
		if(curr != head) {
			propogateCarry(head.next);
			int sum = carry + head.val;
			carry = sum / 10;
			sum = sum%10;
			Node newNode = new Node(sum);
			newNode.next = result;
			result = newNode;
		}
		
	}

	private void addListSameSize(Node head1, Node head2) {
		if(null == head1)
			return ;
		addListSameSize(head1.next, head2.next);
		int sum = head1.val + head2.val + carry;
		carry = carry/10;
		sum = sum%10;
		Node newNode = new Node(sum);
		newNode.next = result;
		result = newNode;
	}
	
}
