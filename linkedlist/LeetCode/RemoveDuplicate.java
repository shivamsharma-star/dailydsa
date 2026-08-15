/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        if(head.next==null) {
            return head;
            }
        ListNode curr2 = head.next;
        while(curr2!=null){

            if(curr.val==curr2.val){
                curr2=curr2.next;
            }else{
            curr.next=curr2;
            curr =curr2;
            curr2=curr2.next;
            }


        }
        curr.next = null;
        return head;
    }
}