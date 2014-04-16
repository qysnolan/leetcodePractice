package yunsheng.leetcode.practise;

//Iteration

public class FlattenBinaryTreetoLinkedList {
	
	public static void flatten(TreeNode root) {
		if(root == null)
			return;
		
		TreeNode node = root;
		
		while(true) {
			while(node.left == null) {
				node = node.right;
				if(node == null)
					break;
			}
			if(node == null)
				break;
			TreeNode right = node.right;
			node.right = node.left;
			node.left = null;
			node = node.right;
			TreeNode newRight = node;
			while(newRight.right != null)
				newRight = newRight.right;
			newRight.right = right;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n = new TreeNode(0).testCase(100);
		n.travesebyLevel(n);
		flatten(n);
		n.travesebyLevel(n);
	}

}
