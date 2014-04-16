package yunsheng.leetcode.practise;

public class RemoveDuplicatesfromSortedListII {
	
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null)
			return head;
		
		ListNode re = new ListNode(0);
		re.next = head;
		ListNode pre = re;
		ListNode cur = head;
		
		while(cur != null && cur.next != null) {
			if(cur.next.val != cur.val) {
				pre = pre.next;
				cur = cur.next;
			}
			else {
				while(cur.next != null && cur.next.val == cur.val) 
					cur = cur.next;
				pre.next = cur.next;
				cur = pre.next;
			}
		}		
		
		return re.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 = {1,2,3,3,4,4,5};
		int[] a2 = {1,1,1,2,3};
		ListNode l1 = new ListNode(0).generateList(a1);
		ListNode l2 = new ListNode(0).generateList(a2);
		
		l1.printList();
		l2.printList();
		
		deleteDuplicates(l1).printList();
		deleteDuplicates(l2).printList();
	}

}
