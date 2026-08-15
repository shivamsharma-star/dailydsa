import java.util.Stack;

class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        Stack<ListNode> stack = new Stack<>();

        // Step 1: Put all nodes into stack
        ListNode curr = head;

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        // Step 2: Reorder
        curr = head;

        while (curr != null) {

            ListNode last = stack.pop();

            // Stop when we reach the middle
            if (last == curr || last == curr.next) {
                last.next = null;
                break;
            }

            ListNode next = curr.next;

            curr.next = last;
            last.next = next;

            curr = next;
        }
    }
}