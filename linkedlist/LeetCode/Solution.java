public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        ListNode curr = head;
        int size = 0;

        // Size calculate
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        // Nth node from end is head
        if (n == size) {
            return head.next;
        }

        curr = head;

        // Previous node tak jao
        for (int i = 0; i < size - n - 1; i++) {
            curr = curr.next;
        }

        // Delete
        curr.next = curr.next.next;

        return head;
    }
} {
    
}
