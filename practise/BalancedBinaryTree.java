package yunsheng.leetcode.practise;

public class BalancedBinaryTree {
	
	public static boolean isBalanced(TreeNode root) {
		if(root == null)
			return true;
		int left = depth(root.left);
		int right = depth(root.right);
		if(Math.abs(left - right) > 1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	private static int depth(TreeNode root) {
		if(root == null)
			return 0;
		return 1 + Math.max(depth(root.left), depth(root.right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n = new TreeNode(0).testCase(100);
		System.out.println(isBalanced(n));
	}

}
