public ListNode remove(ListNode head) {
	ListNode dummy = new ListNode(0);
	ListNode slow = dummy; // tail of the result list
	ListNode fast = head;
	while (fast != null) {
		if (!isVowel(fast.val)) {
			slow.next = fast;
			slow = slow.next;
		}
		fast = fast.next;
	}
	slow.next = null; // delink the tail node
	return dummy.next;
}

public ListNode remove(ListNode head) {
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode slow = dummy;
	while (slow.next != null) {
		if (!isVowel(slow.next.val)) {
			slow = slow.next;
		} else {
			slow.next = slow.next.next;
		}
	}
	return dummy.next;
}