package yunsheng.leetcode.practise;

public class ValidateBinarySearchTree {
	
	public static boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	
	private static boolean isValidBSTHelper(TreeNode root, int max, int min) {
		if(root == null)
			return true;
		if(root.left != null) 
			if(root.left.val >= root.val || root.left.val <= min)
				return false;
		if(root.right != null)
			if(root.right.val <= root.val || root.right.val >= max)
				return false;
		return isValidBSTHelper(root.left, root.val, min) 
				&& isValidBSTHelper(root.right, max, root.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
