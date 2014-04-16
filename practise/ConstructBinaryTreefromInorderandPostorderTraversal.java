package yunsheng.leetcode.practise;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length == 0 || postorder.length == 0 
				|| inorder.length != postorder.length)
			return null;
		return buildTreeHelper(inorder, postorder, 0, 
				inorder.length-1, 0, postorder.length-1);
	}
	
	private static TreeNode buildTreeHelper(int[] inorder, int[] postorder, 
			int start1, int end1, int start2, int end2) {
		if(start1 > end1 || start2 > end2)
			return null;
		TreeNode node = new TreeNode(postorder[end2]);
		if(start1 == end1 || start2 == end2)
			return node;
		
		//Looking for node in inorder
		int breakPoint = start1;
		while(inorder[breakPoint] != postorder[end2]) 
			breakPoint++;
		
		node.left = buildTreeHelper(inorder, postorder, start1, 
				breakPoint-1, start2, start2+(breakPoint-1-start1));
		node.right = buildTreeHelper(inorder, postorder, 
				breakPoint+1, end1, start2+(breakPoint-start1), end2-1);
					
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder = {4,2,8,5,9,1,6,10,3,7};
		int[] postorder = {4,8,9,5,2,10,6,7,3,1};
		TreeNode node = buildTree(inorder, postorder);
		node.travesebyLevel(node);
	}

}
