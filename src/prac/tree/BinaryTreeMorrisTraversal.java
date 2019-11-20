package prac.tree;

public class BinaryTreeMorrisTraversal {

	Node root;
	
	void morrisTraversal() {
		Node curr,prev;
		curr = root;
		while(null != curr) {
			if(null == curr.left) {
				System.out.print(curr.value + " ");
				curr = curr.right;
			}else {
				prev = curr.left;
				while(null != prev.right && prev.right != curr)
					prev = prev.right;
				if(null == prev.right) {
					prev.right = curr;
					curr = curr.left;
				}else{
					prev.right = null;
					System.out.print(curr.value + " ");
					curr = curr.right;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeMorrisTraversal tree = new BinaryTreeMorrisTraversal();
		tree.root = new Node(1, null, null);
		tree.root.left = new Node(2, null, null);
		tree.root.right = new Node(3, null, null);
		tree.root.left.left = new Node(4, null, null);
		tree.root.left.right = new Node(5, null, null);
		
		tree.morrisTraversal();
	}
}
