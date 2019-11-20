package prac.tree;

public class ConstructFromPreAndPostGivenAFullTree {

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}
	
	static int preIndex = 0;
	
	TreeNode constructTree(int[] pre,int[] post,int start,int end,int size) {
		
		if(start > end || preIndex >= size)
			return null;
		
		TreeNode temp = new TreeNode(pre[preIndex++]);
		if(start == end || preIndex >= size)
			return temp;
		int i;
		for(i = start; i<= end;i++) {
			if(post[i] == pre[preIndex]) {
				break;
			}
		}
		
		
		temp.left = constructTree(pre, post, start, i, size);
		temp.right = constructTree(pre, post, i+1, end, size);
		return temp;
	}
	
}
