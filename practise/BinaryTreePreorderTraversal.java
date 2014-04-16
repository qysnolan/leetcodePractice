package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	
	public static ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> re = new ArrayList<Integer>();
		if(root == null)
			return re;
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = root;
		while(cur != null || !s.isEmpty()) {
			if(cur != null) {
				re.add(cur.val);
				s.add(cur);
				cur = cur.left;
			}
			else {
				cur = s.pop();
				cur = cur.right;
			}
		}
		
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n = new TreeNode(0);
		TreeNode t = n.testCase(100);
		t.printPreorder();
		ArrayList<Integer> list = preorderTraversal(t);
		System.out.println(list);
	}

}
