package yunsheng.leetcode.practise;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLinkNode {
	
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { 
		val = x; 
	}
	
	public String toString() {
		if(next == null)
			return Integer.toString(val) + ": " + null;
		else
			return Integer.toString(val) + ": " + next.val;
	}
	
	public TreeLinkNode testCase(int range) {
		
		TreeLinkNode n1 = new TreeLinkNode((int)(Math.random()*range));
		TreeLinkNode n2 = new TreeLinkNode((int)(Math.random()*range));
		TreeLinkNode n3 = new TreeLinkNode((int)(Math.random()*range));
		TreeLinkNode n4 = new TreeLinkNode((int)(Math.random()*range));
		TreeLinkNode n5 = new TreeLinkNode((int)(Math.random()*range));
		TreeLinkNode n6 = new TreeLinkNode((int)(Math.random()*range));
		TreeLinkNode n7 = new TreeLinkNode((int)(Math.random()*range));
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.left = n5;
		n5.right = n6;
		n3.right = n7;
    	
      	return n1;
	}
	
	public void travesebyLevel(TreeLinkNode root) {
		if(root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(null);
		queue.offer(root);
		
		int level = 1;
		while(queue.size() > 1) {
			TreeLinkNode cur = queue.poll();
			if(cur == null) {
				System.out.println();
				System.out.print((level++) + ": ");
				queue.add(null);
				continue;
			}
			System.out.print(cur);
			System.out.print(", ");
			if(cur.left != null)
				queue.offer(cur.left);
			if(cur.right != null)
				queue.offer(cur.right);
		}
		
	}

}
