package yunsheng.leetcode.practise;

public class RemoveDuplicatesfromSortedList {
	
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode cur = head;
		ListNode next = head.next;
		
		while(next != null) {
			if(cur.val != next.val) {
				cur = next;
				next = next.next;
			}
			else {
				cur.next = next.next;
				next = cur.next;
			}
		}
		
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 = {1,1,2};
		int[] a2 = {1,1,2,3,3};
		ListNode l1 = new ListNode(0).generateList(a1);
		ListNode l2 = new ListNode(0).generateList(a2);
		
		l1.printList();
		l2.printList();
		
		deleteDuplicates(l1).printList();
		deleteDuplicates(l2).printList();
	}

}
