public class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode pt1 = head;      // slow
        ListNode pt2 = head;      // fast

        while (pt2 != null && pt2.next != null) {
            pt1 = pt1.next;           // move 1 step
            pt2 = pt2.next.next;      // move 2 steps

            if (pt1 == pt2) {
                return true;
            }
        }

        return false;
    }
}