package yunsheng.leetcode.practise;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {
	
	public static void connect(TreeLinkNode root) {
		if(root == null)
			return;
		
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		TreeLinkNode pre = null;
		queue.offer(null);
		queue.offer(root);
		
		while(queue.size() > 1) {
			TreeLinkNode cur = queue.poll();
			if(pre != null)
				pre.next = cur;
			pre = cur;
			if(cur == null) {
				queue.offer(null);
				continue;
			}
			if(cur.left != null)
				queue.offer(cur.left);
			if(cur.right != null)
				queue.offer(cur.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode n = new TreeLinkNode(0).testCase(100);
		n.travesebyLevel(n);
		connect(n);
		n.travesebyLevel(n);
	}

}
