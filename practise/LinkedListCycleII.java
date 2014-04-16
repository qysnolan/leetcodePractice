package yunsheng.leetcode.practise;

public class LinkedListCycleII {
	
	public static ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null)
			return null;
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)
				break;
		}
		
		if(fast != slow)
			return null;
		
		fast = head;
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return fast;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(0).testCast(6, 100);
		l.printList();
		System.out.println(detectCycle(l));
		l.testCastAddCycle(4);
		System.out.println(detectCycle(l));
	}

}
