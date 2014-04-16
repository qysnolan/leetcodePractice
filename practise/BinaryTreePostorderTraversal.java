package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	
	public static ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> re = new ArrayList<Integer>();
		if(root == null)
			return re;
		
		TreeNode lastvisited = null;
		TreeNode cur = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(cur != null || !s.isEmpty()) {
			if(cur != null) {
				s.push(cur);
				cur = cur.left;
			}
			else {
				TreeNode top = s.peek();
				if(top.right != null && top.right != lastvisited)
					cur = top.right;
				else {
					s.pop();
					lastvisited = top;
					re.add(top.val);
				}
			}
		}
		
		return re;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n = new TreeNode(0);
		TreeNode t = n.testCase(100);
		t.printPostorder();
		ArrayList<Integer> list = postorderTraversal(t);
		System.out.println(list);
	}

}
