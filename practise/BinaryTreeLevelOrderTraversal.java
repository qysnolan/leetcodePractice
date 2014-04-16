package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> re  = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			return re;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(null);
		queue.offer(root);
		ArrayList<Integer> integers = new ArrayList<Integer>();
		
		while(queue.size() > 1) {
			TreeNode cur = queue.poll();
			if(cur == null) {
				queue.add(null);
				if(!integers.isEmpty()) {
					ArrayList<Integer> tmp = new ArrayList<Integer>(integers);
					re.add(tmp);
					integers.clear();
				}
				continue;
			}
			integers.add(cur.val);
			if(cur.left != null)
				queue.offer(cur.left);
			if(cur.right != null)
				queue.offer(cur.right);
		}
		re.add(integers);
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(0).testCase(100);
		node.travesebyLevel(node);
		System.out.println(levelOrder(node));
	}

}
