package yunsheng.leetcode.practise;

public class SymmetricTree {
	
	public static boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		return isSymmetricHelper(root.left, root.right);
	}
	
	public static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
		if(left == null && right == null)
			return true;
		if(left == null || right == null)
			return false;
		if(left.val != right.val)
			return false;
		return isSymmetricHelper(left.left, right.right) 
				&& isSymmetricHelper(left.right, right.left);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(0).testCase(100);
		node.travesebyLevel(node);
		System.out.println(isSymmetric(node));
	}

}
