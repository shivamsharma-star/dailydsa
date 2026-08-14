class MeargeSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode();
        ListNode result = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val > list2.val) {
                result.next = list2;
                list2 = list2.next;
            } else {
                result.next = list1;
                list1 = list1.next;
            }

            result = result.next;
        }

        if (list1 != null) {
            result.next = list1;
        } else {
            result.next = list2;
        }

        return dummy.next;
    }
}