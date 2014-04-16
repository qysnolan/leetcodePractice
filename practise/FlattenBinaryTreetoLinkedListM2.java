package yunsheng.leetcode.practise;

//Recursion

public class FlattenBinaryTreetoLinkedListM2 {
	
	public static void flatten(TreeNode root) {
        if(root == null) 
            return;
        if(root.left == null) {
            flatten(root.right);
            return;
        }
         
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        if(right != null){
            TreeNode runner = left;
            while(runner.right != null)
                runner = runner.right;
            runner.right = right;
        }
        root.right = left;
        flatten(left);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n = new TreeNode(0).testCase(100);
		n.travesebyLevel(n);
		flatten(n);
		n.travesebyLevel(n);
	}

}
