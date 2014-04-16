package yunsheng.leetcode.practise;

import java.util.ArrayList;

public class PathSumII {
	
	public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			return re;
		ArrayList<Integer> cur = new ArrayList<Integer>();
		pathSumHelper(root, sum, re, cur);
		return re;
	}
	
	private static void pathSumHelper(TreeNode root, int sum, 
			ArrayList<ArrayList<Integer>> re, ArrayList<Integer> cur) {
		if(root == null) 
			return;
		if(root.left == null && root.right == null && root.val == sum) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(cur);
			tmp.add(root.val);
			re.add(tmp);
			return;
		}
		cur.add(root.val);
		pathSumHelper(root.left, sum - root.val, re, cur);
		pathSumHelper(root.right, sum - root.val, re, cur);
		cur.remove(cur.size() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(11);
		TreeNode n5 = new TreeNode(13);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(5);
		TreeNode n10 = new TreeNode(1);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.left = n5;
		n3.right = n6;
		n4.left = n7;
		n4.right = n8;
		n6.left = n9;
		n6.right = n10;
		n1.travesebyLevel(n1);
		System.out.println(pathSum(n1, 22));
	}

}
