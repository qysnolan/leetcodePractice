package yunsheng.leetcode.practise;

public class AddTwoNumbers {
	
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode runner1=l1;
        ListNode runner2=l2;
        ListNode head = new ListNode(-1);
        ListNode runner = head;
        int carry=0;
        while(runner1!=null || runner2!=null || carry!=0){
            int val1 = runner1==null ? 0 : runner1.val;
            int val2 = runner2==null ? 0 : runner2.val;
            int sum = val1 + val2 + carry;
            carry = sum/10;
            runner.next = new ListNode(sum%10);
            runner = runner.next;
            runner1 = runner1==null ? null : runner1.next;
            runner2 = runner2==null ? null : runner2.next;
        }
        return head.next;	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
