class Solution {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = res * 2 + head.val;
            head = head.next;
        }
        return res;
    }
}

// e.g. 111
// index = 0, num = 1
// index = 1, num = 1 * 2 + 1 = 3
// index = 2, num = (2 + 1) * 2 + 1 = 7