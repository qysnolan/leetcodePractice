package yunsheng.leetcode.practise;

public class ConvertSortedArraytoBinarySearchTree {
	
	public static TreeNode sortedArrayToBST(int[] num) {
		if(num.length == 0)
			return null;
		return sortedArrayToBSTHelper(num, 0, num.length - 1);
	}
	
	private static TreeNode sortedArrayToBSTHelper(int[] num, int start, int end) {
		if(start > end)
			return null;
		int mid = (start + end)/2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = sortedArrayToBSTHelper(num, start, mid - 1);
		node.right = sortedArrayToBSTHelper(num, mid + 1, end);
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3,4,5,6,7,8,9};
		TreeNode node = sortedArrayToBST(num);
		node.travesebyLevel(node);
	}

}
