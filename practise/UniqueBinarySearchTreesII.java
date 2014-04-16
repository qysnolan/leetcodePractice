package yunsheng.leetcode.practise;

import java.util.ArrayList;

public class UniqueBinarySearchTreesII {
	
	public static ArrayList<TreeNode> generateTrees(int n) {		
		return generateTreesHelper(1, n);
	}
	
	private static ArrayList<TreeNode> generateTreesHelper(int start, int end) {
		ArrayList<TreeNode> re = new ArrayList<TreeNode>();
		if(start > end) 
			re.add(null);
		else if(start == end) 
			re.add(new TreeNode(start));
		else {
			for(int i = start; i <= end; i++) {
				ArrayList<TreeNode> left = generateTreesHelper(start, i-1);
				ArrayList<TreeNode> right = generateTreesHelper(i+1, end);
				for(TreeNode l : left)
					for(TreeNode r : right) {
						TreeNode tmp = new TreeNode(i);
						tmp.left = l;
						tmp.right = r;
						re.add(tmp);
					}
			}
		}
				
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<TreeNode> test = generateTrees(3);
		for(TreeNode n : test)
			n.travesebyLevel(n);
	}

}
