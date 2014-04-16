package yunsheng.leetcode.practise;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length == 0 || inorder.length == 0 
				|| preorder.length != inorder.length)
			return null;
		return buildTreeHelper(preorder, inorder, 0, 
				preorder.length-1, 0, inorder.length-1);
	}
	
	private static TreeNode buildTreeHelper(int[] preorder, int[] inorder, 
			int start1, int end1, int start2, int end2) {
		if(start1 > end1 || start2 > end2)
			return null;
		TreeNode node = new TreeNode(preorder[start1]);
		if(start1 == end1 || start2 == end2)
			return node;
		
		//Looking for node in inorder
		int breakPoint = start2;
		while(preorder[start1] != inorder[breakPoint]) 
			breakPoint++;
		
		node.left = buildTreeHelper(preorder, inorder, start1+1, 
				end1-(end2-breakPoint), start2, breakPoint-1);
		node.right = buildTreeHelper(preorder, inorder, 
				end1-(end2-breakPoint-1), end1, breakPoint+1, end2);
					
		return node;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {1,2,4,5,8,9,3,6,10,7};
		int[] inorder = {4,2,8,5,9,1,6,10,3,7};
		TreeNode node = buildTree(preorder, inorder);
		node.travesebyLevel(node);
	}

}
