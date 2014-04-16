package yunsheng.leetcode.practise;

import java.util.HashMap;

public class LRUCache {
	
	HashMap<Integer, DoubleListNode> map = new HashMap<Integer, DoubleListNode>();
	DoubleListNode head;
	DoubleListNode end;
	int capacity;
	int len;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		len = 0;
	}
	
	public int get(int key) {
		if(map.containsKey(key)) {
			DoubleListNode tmp = map.get(key);
			removeNode(tmp);
			setHead(tmp);
			return tmp.val;
		}
		return -1;
	}
	
	public void set(int key, int value) {
		if(map.containsKey(key)) {
			DoubleListNode tmp = map.get(key);
			tmp.val = value;
			removeNode(tmp);
			setHead(tmp);
			return;
		}
		DoubleListNode cur = new DoubleListNode(key, value);
		if(len < capacity) 
			len++;
		else {
			DoubleListNode deleteNode = end;
			end = end.pre;
			if(end != null)
				end.next = null;
			map.remove(deleteNode.key);
		}
		setHead(cur);
		map.put(key, cur);
			
	}
	
	private void removeNode(DoubleListNode node) {
		if(node.next == null && node.pre == null) {
			head = null;
			end = null;
		}			
		else if(node.pre == null) {
			head = node.next;
			head.pre = null;
		}
		else if(node.next == null) {
			end = node.pre;
			end.next = null;			
		}
		else {
			DoubleListNode next = node.next;
			DoubleListNode pre = node.pre;
			next.pre = pre;
			pre.next = next;
		}
	}
	
	private void setHead(DoubleListNode node) {
		if(head != null) {
			head.pre = node;
			node.next = head;
			head = node;
			node.pre = null;
		}
		else {
			head = node;
			end = node;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class DoubleListNode {
	
	int val;
	int key;
	DoubleListNode next;
	DoubleListNode pre;
	
	public DoubleListNode(int key, int val) {
		this.val = val;
		this.key = key;
		next = null;
		pre = null;
	}
}
