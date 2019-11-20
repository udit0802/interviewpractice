package prac.tree;

public class ConstructTreeWithParentArray {

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
	
	TreeNode root;
	
	TreeNode constructTree(int[] parent) {
		
		TreeNode[] created = new TreeNode[parent.length];
		for(int i = 0; i < created.length;i++)
			created[i] = null;
		for(int i = 0; i < created.length;i++) {
			buildTree(created,i,parent);
		}
		return root;
	}

	private void buildTree(TreeNode[] created, int i, int[] parent) {
		
		if(created[i] != null)
			return;
		
		created[i] = new TreeNode(i);
		
		if(parent[i] == -1) {
			root = created[i];
			return;
		}
		
		if(null == created[parent[i]]) {
			buildTree(created, parent[i], parent);
		}
		
		TreeNode par = created[parent[i]];
		if(null == par.left)
			par.left = created[i];
		else
			par.right = created[i];
	}
	
	void inOrderMorris(TreeNode root) {
		
		
		if(null == root)
			return;
		
		TreeNode curr = root;
		
		while(curr != null) {
			
			if(null == curr.left) {
				System.out.print(curr.val);
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
					System.out.print(curr.val);
					curr = curr.right;
				}
			}
			
			
		}
		
	}
	
	
	public static void main(String[] args) {
		ConstructTreeWithParentArray c = new ConstructTreeWithParentArray();
		int[] parent = {-1,0,0,1,1,3,5};
		TreeNode t = c.constructTree(parent);
		c.inOrderMorris(t);
	}
}
