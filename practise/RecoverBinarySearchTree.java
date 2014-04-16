package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.Stack;

public class RecoverBinarySearchTree {
	
	public static void recoverTree(TreeNode root) {
		if(root == null || (root.left == null && root.right == null))
			return;
		
		TreeNode pre = null;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = root;
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		
		while(!s.isEmpty() || cur != null) {
			if(cur != null) {
				s.push(cur);
				cur = cur.left;				
			}
			else {
				cur = s.pop();
				if(pre != null) {
					if(pre.val > cur.val) {
						if(list.isEmpty()) {
							list.add(pre);
							list.add(cur);
						}
						else {
							list.remove(1);
							list.add(cur);
						}
					}
				}
				pre = cur;
				cur = cur.right;
			}
		}
		
		int tmp = list.get(0).val;
		list.get(0).val = list.get(1).val;
		list.get(1).val = tmp;
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(1);
		n1.left = n2;
		n1.right = n3;
		n1.travesebyLevel(n1);
		recoverTree(n1);
		n1.travesebyLevel(n1);
	}

}
