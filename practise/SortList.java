package yunsheng.leetcode.practise;

public class SortList {
	
	public static ListNode sortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode node = separateList(head);
		ListNode node1 = sortList(head);
		ListNode node2 = sortList(node);
		return mergeList(node1, node2);	
	}
	
	public static ListNode separateList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode node = slow.next;
		slow.next = null;
		
		return node;
	}
	
	public static ListNode mergeList(ListNode node1, ListNode node2) {
		ListNode r1 = node1;
		ListNode r2 = node2;
		ListNode foo = new ListNode(0);
		ListNode r = foo;
		
		while(r1 != null && r2 != null) {
			if(r1.val <= r2.val) {
				r.next = r1;
				r1 = r1.next;				
			}
			else {
				r.next = r2;
				r2 = r2.next;
			}
			r.next.next = null;
			r = r.next;
		}
		
		if(r1 != null)
			r.next = r1;
		else if(r2 != null)
			r.next = r2;
		
		return foo.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(0).testCast(10, 1000);
		l.printList();
		sortList(l).printList();;
	}

}
