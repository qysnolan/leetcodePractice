package yunsheng.leetcode.practise;

import java.util.HashMap;

//Use hash map to store original node and the related copy

public class CopyListwithRandomPointerM2 {
	
	public static RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return head;
		
		RandomListNode re = new RandomListNode(head.label);
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		map.put(head, re);
		RandomListNode r1 = head;
		RandomListNode r2 = re;
		while(r1.next != null) {
			r1 = r1.next;
			RandomListNode tmp = new RandomListNode(r1.label);
			r2.next = tmp;
			r2 = r2.next;
			map.put(r1, r2);
		}
		
		r1 = head;
		while(r1 != null) {
			if(r1.random != null) 
				map.get(r1).random = map.get(r1.random);
			r1 = r1.next;
		}
		
		return re;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode l = new RandomListNode(10).testCast(10, 100);
		l.printList();
		copyRandomList(l).printList();
	}

}
