package prac.tree;

public class LargestBSTinBinaryTreeProblem {

	private static MinMax lengthOfLargestBST(Node root) {
		if(null == root)
			return new MinMax();
		MinMax left = lengthOfLargestBST(root.left);
		MinMax right = lengthOfLargestBST(root.right);
		
		MinMax current = new MinMax();
		
		if(left.max > root.value || right.min < root.value || !left.isBst || !right.isBst) {
			current.isBst = false;
			current.numOfNodes = Math.max(left.numOfNodes, right.numOfNodes);
			return current;
		}
		
		current.isBst = true;
		current.numOfNodes = 1 + left.numOfNodes + right.numOfNodes;
		
		current.min = (null == root.left)?root.value:left.min;
		current.max = (null == root.right)?root.value:right.max;
		
		return current;
	}
	
	public static void main(String[] args) {
		ConstructTreeFromInorderAndPreorder ctf = new ConstructTreeFromInorderAndPreorder();
        //this is just to create a binary tree.
        int inorder[]  = {-7,-6,-5,-4,-3,-2,1,2,3,16,6,10,11,12,14};
        int preorder[] = {3,-2,-3,-4,-5,-6,-7,1,2,16,10,6,12,11,14};
        Node root = ctf.constructTree(inorder, preorder,0,inorder.length);
        System.out.println("largest BST = " + lengthOfLargestBST(root).numOfNodes);
	}
	
	private static class MinMax{
		int numOfNodes;
		boolean isBst;
		int min;
		int max;
		public MinMax() {
			super();
			this.numOfNodes = 0;
			this.isBst = true;
			this.min = Integer.MAX_VALUE;
			this.max = Integer.MIN_VALUE;
		}
		
		
	}
	
	
}
