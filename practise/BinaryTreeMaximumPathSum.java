package yunsheng.leetcode.practise;

import java.util.ArrayList;

public class BinaryTreeMaximumPathSum {
	
	public static int maxPathSum(TreeNode root) {
		if(root == null)
			return 0;
		ArrayList<Integer> re = new ArrayList<Integer>();
		re.add(root.val);
		maxPathSumHelper(root, re);
		return re.get(0);
	}
	
	private static int maxPathSumHelper(TreeNode root, ArrayList<Integer> re) {
		if(root == null)
			return 0;
		int left = maxPathSumHelper(root.left, re);
		int right = maxPathSumHelper(root.right, re);
		int tmp = Math.max(root.val, Math.max(root.val + left, root.val + right));
		re.set(0, Math.max(re.get(0), Math.max(tmp, root.val + left + right)));
		return tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t = new TreeNode(0).testCase(10);
		t.printInorder();
		System.out.println(maxPathSum(t));
	}

}
