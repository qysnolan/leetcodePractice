package yunsheng.leetcode.practise;

public class ReverseLinkedListII {
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null || head.next == null)
			return head;
		
		ListNode foo = new ListNode(0);
		foo.next = head;
		head = foo;
		ListNode pre = head;
		int k = m - 1;
		while(k > 0) {
			pre = pre.next;
			k--;
		}
		
		k = n - m;
		ListNode cur = pre.next;
        while(cur.next != null && k > 0){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            k--;
        }
		
		return head.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n = new ListNode(0).testCast(1, 100);
		n.printList();
		reverseBetween(n, 1, 1).printList();
	}

}
