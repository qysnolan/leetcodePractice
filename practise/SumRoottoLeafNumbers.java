package yunsheng.leetcode.practise;

public class SumRoottoLeafNumbers {
	
	public static int sumNumbers(TreeNode root) {
		return sumNumbersHelper(root, 0);
	}
	
	public static int sumNumbersHelper(TreeNode root, int sum) {
		if(root == null)
			return 0;
		int re = root.val + sum*10;
		if(root.left == null && root.right == null)
			return re;
		return sumNumbersHelper(root.left, re) + sumNumbersHelper(root.right, re);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		
		n1.left = n2;
		n1.right = n3;
		System.out.println(sumNumbers(n1));
	}

}
