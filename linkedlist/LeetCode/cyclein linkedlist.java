public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode pt1 = head;   // slow
        ListNode pt2 = head;   // fast

        while (pt2 != null && pt2.next != null) {

            pt1 = pt1.next;          // 1 step
            pt2 = pt2.next.next;     // 2 steps

            if (pt1 == pt2) {
                return true;
            }
        }

        return false;
    }
}