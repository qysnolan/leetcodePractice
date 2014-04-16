package yunsheng.leetcode.practise;

//Copy the node next to the original one and then copy random. 
//Finally break it.

public class CopyListwithRandomPointer {
	
	public static RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return null;
		
		//insert node
		RandomListNode runner = head;
		while(runner != null) {
			RandomListNode copy = new RandomListNode(runner.label);
			RandomListNode next = runner.next;
			runner.next = copy;
			copy.next = next;
			runner = next;
		}
		//copy random pointers
		runner = head;
		while(runner != null) {
			RandomListNode copy = runner.next;
			if(runner.random != null) 
				copy.random = runner.random.next;
			runner = copy.next;			
		}
		//separate list
		RandomListNode re = new RandomListNode(0);
		runner = head;
		RandomListNode r2 = re;
		while(runner != null) {
			RandomListNode tmp = runner.next;
			r2.next = tmp;
			runner.next = tmp.next;
			tmp.next = null;
			runner = runner.next;
			r2 = r2.next;
		}
		
		return re.next;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode l = new RandomListNode(10).testCast(10, 100);
		l.printList();
		copyRandomList(l).printList();
	}

}
