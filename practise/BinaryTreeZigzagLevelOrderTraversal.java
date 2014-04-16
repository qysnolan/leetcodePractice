package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
	
	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			return re;
		
		Stack<TreeNode> cur = new Stack<TreeNode>();
		Stack<TreeNode> next = new Stack<TreeNode>();
		cur.push(root);
		int level = 1;
		
		while(!cur.isEmpty()) {
			ArrayList<Integer> integers = new ArrayList<Integer>();
			while(!cur.isEmpty()) {
				TreeNode node = cur.pop();
				integers.add(node.val);
				if(level%2 != 0) {
					if(node.left != null)
						next.push(node.left);
					if(node.right != null)
						next.push(node.right);
				}
				else {
					if(node.right != null)
						next.push(node.right);
					if(node.left != null)
						next.push(node.left);					
				}
			}
			re.add(integers);
			Stack<TreeNode> tmp = cur;
			cur = next;
			next = tmp;
			level++;
		}
		
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(0).testCase(100);
		node.travesebyLevel(node);
		System.out.println(zigzagLevelOrder(node));
	}

}
