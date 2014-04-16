package yunsheng.leetcode.practise;

public class LinkedListCycle {
	
	public static boolean hasCycle(ListNode head) {
		if(head == null || head.next == null)
			return false;
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)
				return true;
		}
		
		return false;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(0).testCast(10, 100);
		l.printList();
		System.out.println(hasCycle(l));
		l.testCastAddCycle(4);
		System.out.println(hasCycle(l));
	}

}
