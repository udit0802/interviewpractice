package prac.tree;

public class BinaryTreeVerticalOrder {
	
	private Node root;
	
	class Values {
		int min;
		int max;
	}

	void findMinMaxWidth(Node node,Values min,Values max,int hd) {
		
		if(null == node)
			return;
		if(hd < min.min)
			min.min = hd;
		else if(hd > max.max)
			max.max = hd;
		findMinMaxWidth(node.left, min, max, hd-1);
		findMinMaxWidth(node.right, min, max, hd+1);
		
	}
	
	void printVertical() {
		Values val = new Values();
		findMinMaxWidth(root, val, val, 0);
		
		for(int line_no = val.min;line_no <= val.max;line_no++) {
			printVerticalUtil(root,line_no,0);
			System.out.println();
		}
	}
	
	private void printVerticalUtil(Node node, int line_no, int hd) {
		if(null == node)
			return;
		
		if(line_no == hd)
			System.out.print(node.value + " ");
		printVerticalUtil(node.left, line_no, hd-1);
		printVerticalUtil(node.right, line_no, hd+1);
		
	}

	public static void main(String[] args) {
		
		BinaryTreeVerticalOrder vo = new BinaryTreeVerticalOrder();
		vo.root = new Node(1, null, null);
		vo.root.left = new Node(2, null, null);
		vo.root.right = new Node(3, null, null);
		vo.root.left.left = new Node(4, null, null);
		vo.root.left.right = new Node(5, null, null);
		vo.root.right.left = new Node(6, null, null);
		vo.root.right.right = new Node(7, null, null);
		vo.root.right.left.right = new Node(8, null, null);
		vo.root.right.right.right = new Node(9, null, null);
		vo.printVertical();

	}

}
