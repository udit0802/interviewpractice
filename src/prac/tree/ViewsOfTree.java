package prac.tree;

import java.util.Map;
import java.util.TreeMap;

public class ViewsOfTree {
	
	private int maxLevel = 0;
	private Map<Integer,Integer> map = null;

	public class TreeNode{
		int val;
		TreeNode left,right;
		public TreeNode(int val) {
			super();
			this.val = val;
		}
	}
	
	
	private void leftView(TreeNode root,int level) {
		if(null == root)
			return;
		
		if(maxLevel < level) {
			maxLevel = level;
			System.out.print(root.val + " ");
		}
		leftView(root.left, level+1);
		leftView(root.right, level+1);
	}
	
	private void rightView(TreeNode root,int level) {
		if(null == root)
			return;
		
		if(maxLevel < level) {
			maxLevel = level;
			System.out.print(root.val + " ");
		}
		leftView(root.right, level+1);
		leftView(root.left, level+1);
	}
	
	private void bottomView(TreeNode root,int hd) {
		if(null == root)
			return;
		map.put(hd,root.val);
		bottomView(root.left, hd-1);
		bottomView(root.right, hd+1);
	}
	
	private void topView(TreeNode root,int hd) {
		if(null == root)
			return;
		if(!map.containsKey(hd))
			map.put(hd,root.val);
		topView(root.left, hd-1);
		topView(root.right, hd+1);
	}
	
	public static void main(String[] args) {
		ViewsOfTree view = new ViewsOfTree();
		TreeNode node = view.new TreeNode(12);
		node.left = view.new TreeNode(10);
		node.right = view.new TreeNode(30);
		node.right.left = view.new TreeNode(25);
		node.right.right = view.new TreeNode(40);
		view.leftView(node, 1);
		System.out.println();
		view.maxLevel = 0;
		view.rightView(node, 1);
		System.out.println();
		view.map = new TreeMap<>();
		view.bottomView(node, 0);
		for(Map.Entry<Integer, Integer> entry : view.map.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
		
		System.out.println();
		view.map = new TreeMap<>();
		view.topView(node, 0);
		for(Map.Entry<Integer, Integer> entry : view.map.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
	}
	
}
