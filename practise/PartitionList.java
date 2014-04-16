package yunsheng.leetcode.practise;

public class PartitionList {
	
	public static ListNode partition(ListNode head, int x) {
		if(head == null || head.next == null)
			return head;
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);
		l1.next = head;
		ListNode r1 = head;
		ListNode r2 = l2;
		ListNode pre = l1;
		while(r1 != null) {
			if(r1.val >= x) {
				pre.next = r1.next;
				r1.next = null;
				r2.next = r1;
				r2 = r2.next;
				r1 = pre.next;
			}
			else {
				pre = pre.next;
				r1 = r1.next;
			}
		}
		pre.next = l2.next;
		l2.next = null;
		
		return l1.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(0).testCast(10, 100);
		l.printList();
		partition(l, 50).printList();;	
	}

}
