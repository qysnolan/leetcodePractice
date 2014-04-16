package yunsheng.leetcode.practise;

public class ConvertSortedListtoBinarySearchTree {
	
	public static TreeNode sortedListToBST(ListNode head) {
		if(head == null)
			return null;
		if(head.next == null)
			return new TreeNode(head.val);
		
		ListNode fast = head;
		ListNode slow = head;
		ListNode pre = head;
		while(fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode node = new TreeNode(slow.val);
		pre.next = null;
		pre = slow.next;
		slow.next = null;
		node.left = sortedListToBST(head);
		node.right = sortedListToBST(pre);
		
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode list = new ListNode(0).testCast(10, 100);
		list.printList();
		TreeNode node = sortedListToBST(list);
		node.travesebyLevel(node);
	}

}
