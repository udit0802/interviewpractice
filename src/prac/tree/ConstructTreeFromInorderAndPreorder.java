package prac.tree;

import java.util.Stack;

public class ConstructTreeFromInorderAndPreorder {
	
	static int preIndex = 0;
	
	class TreeNode{
		char value;
		TreeNode left = null;
		TreeNode right = null;
		public TreeNode(char c) {
			value = c;
		}
	}

	int search(char c,char[] inorder) {
		for(int i = 0;i < inorder.length;i++)
			if(inorder[i] == c)
				return i;
		return -1;
	}
	
	TreeNode constructTree(char[] in,char[] pre,int inStart,int inEnd) {
		
		if(inStart > inEnd)
			return null;
		
		TreeNode newNode = new TreeNode(pre[preIndex++]);
		if(inStart == inEnd)
			return newNode;
		
		int inIndex = search(newNode.value, in);
		
		newNode.left = constructTree(in, pre, inStart, inIndex-1);
		newNode.right = constructTree(in, pre, inIndex+1, inEnd);
		return newNode;
	}
	
	void inorderRec(TreeNode t) {
		if(null == t)
			return;
		inorderRec(t.left);
		System.out.print(t.value);
		inorderRec(t.right);
	}
	//with stack without recursion
	void inOrderIter(TreeNode t) {
		
		if(null == t)
			return;
		
		Stack<TreeNode> s = new Stack<>();
		TreeNode curr = t;
		while(curr != null || s.size() > 0) {
			
			
			while(curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			
			curr = s.pop();
			System.out.print(curr.value);
			
			curr = curr.right;
		}
	}
	
	void inOrderMorris(TreeNode root) {
		if(null == root)
			return;
		TreeNode curr = root;
		
		while(curr != null) {
			
			if(null == curr.left) {
				System.out.print(curr.value);
				curr = curr.right;
			
			}else {
				
				TreeNode pre = curr.left;
				while(pre.right != null && pre.right != curr) {
					pre = pre.right;
				}
				
				if(null == pre.right) {
					pre.right = curr;
					curr = curr.left;
				}else if(pre.right == curr) {
					pre.right = null;
					System.out.print(curr.value);
					curr = curr.right;
				}
			}
			
			
		}
		
	}

	public static void main(String[] args) {
		
		char[] in = {'D','B','E','A','F','C'};
		char[] pre = {'A','B','D','E','C','F'};
		ConstructTreeFromInorderAndPreorder c = new ConstructTreeFromInorderAndPreorder();
		TreeNode root = c.constructTree(in, pre, 0, in.length-1);
		c.inorderRec(root);
		c.inOrderIter(root);
		c.inOrderMorris(root);
		
	}
}
