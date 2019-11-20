package prac.tree;

public class FlattenTreeToLinkedList {

	
	class TreeNode{
		
		int val;
		TreeNode left,right;
		public TreeNode(int val) {
			super();
			this.val = val;
			left = null;
			right = null;
		}
		
		
		void flatten(TreeNode node) {
			if(node == null || (node.left == null && node.right == null))
				return;
			if(null != node.left) {
				flatten(node.left);
				TreeNode temp = node.right;
				node.right = node.left;
				node.left = null;
				TreeNode t = node.right;
				while(t.right  != null) {
					t = t.right;
				}
				t.right = temp;
			}
			flatten(node.right);
		}
		
	}
}
