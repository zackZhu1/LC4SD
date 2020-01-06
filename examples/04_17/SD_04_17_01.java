public void reverse(ListNode head) {
	ListNode cur = head;
	while (cur != null) {
		ListNode next = cur.next;
		cur.next = cur.prev;
		cur.prev = next;
		cur = next;
	}
}

public ListNode reverse(ListNode head) {
	ListNode prev = null;
	ListNode cur = head;
	while (cur != null) {
		ListNode next = cur.next;
		cur.next = cur.prev;
		cur.prev = next;

		prev = cur;
		cur = next;
	}
	
	return prev;
}