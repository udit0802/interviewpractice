package prac.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BinaryTreeIsBSTProblem {

	private static boolean isBST(Node root,int min,int max){
		if(null == root)
			return true;
		if(root.value < min || root.value > max) {
			return false;
		}
		return isBST(root.left, min, root.value) && isBST(root.right, root.value, max);
	}
	
	//this is based on inorder traversal
	
	private static boolean isBSTIterative(Node root) {
		if(null == root)
			return true;
		Node node = root;
		int prev = Integer.MIN_VALUE;
		Stack<Node> stack = new Stack<Node>();
		while(true) {
			if(node != null) {
				stack.push(node);
				node = node.left;
			}else {
				if(stack.isEmpty())
					break;
				node = stack.pop();
				int current = node.value;
				if(current < prev)
					return false;
				prev = current;
				node = node.right;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Node root = new Node(20, null, null);
		root.left = new Node(15, null, null);
		root.right = new Node(21, null, null);
		
		System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println(isBSTIterative(root));
		
	}
}
