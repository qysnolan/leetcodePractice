package yunsheng.leetcode.practise;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x) { 
		val = x; 
	}
	
	public String toString() {
		return Integer.toString(val);
	}
	
	public void printNode() {
		System.out.println(val);
	}
	
	public void printPreorder() {
		System.out.print("Preorder by recursion: ");
		printPreorderHelper(this);
		System.out.println();
	}
	
	private void printPreorderHelper(TreeNode node) {
		if(node == null)
			return;
		System.out.print(node.val);
		System.out.print("-");
		printPreorderHelper(node.left);
		printPreorderHelper(node.right);
	}
	
	public void printInorder() {
		System.out.print("Inorder by recursion: ");
		printInorderHelper(this);
		System.out.println();
	}
	
	private void printInorderHelper(TreeNode node) {
		if(node == null)
			return;
		printInorderHelper(node.left);
		System.out.print(node.val);
		System.out.print("-");
		printInorderHelper(node.right);
	}
	
	public void printPostorder() {
		System.out.print("Postorder by recursion: ");
		printPostorderHelper(this);
		System.out.println();
	}
	
	private void printPostorderHelper(TreeNode node) {
		if(node == null)
			return;
		printPostorderHelper(node.left);
		printPostorderHelper(node.right);
		System.out.print(node.val);
		System.out.print("-");
	}
	
	public void travesebyLevel(TreeNode root) {
		if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(null);
		queue.offer(root);
		
		int level = 1;
		while(queue.size() > 1) {
			TreeNode cur = queue.poll();
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
		System.out.println();
	}
	
	public TreeNode testCase(int range) {
		TreeNode n1 = new TreeNode((int)(Math.random()*range));
		TreeNode n2 = new TreeNode((int)(Math.random()*range));
		TreeNode n3 = new TreeNode((int)(Math.random()*range));
		TreeNode n4 = new TreeNode((int)(Math.random()*range));
		TreeNode n5 = new TreeNode((int)(Math.random()*range));
		TreeNode n6 = new TreeNode((int)(Math.random()*range));
		TreeNode n7 = new TreeNode((int)(Math.random()*range));
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.left = n5;
		n5.right = n6;
		n3.right = n7;
    	
      	return n1;
	}
}
