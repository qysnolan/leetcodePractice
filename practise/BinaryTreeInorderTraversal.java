package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	
	public static ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> re = new ArrayList<Integer>();
		if(root == null)
			return re;
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = root;
		while(cur != null || !s.isEmpty()) {
			if(cur != null) {
				s.push(cur);
				cur = cur.left;
			}
			else {
				cur = s.pop();
				re.add(cur.val);
				cur = cur.right;
			}
		}
		
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n = new TreeNode(0);
		TreeNode t = n.testCase(100);
		t.printInorder();
		ArrayList<Integer> list = inorderTraversal(t);
		System.out.println(list);
	}

}
