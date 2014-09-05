/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class MergeKSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode result = lists.size() > 0 ? lists.get(0) : null;
        for (int i = 1; i < lists.size(); i++) {
            result = mergeTwoLists(result, lists.get(i));
        }
        return result;
    }
    
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        dummy.next = list1;
        ListNode prev = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                prev.next = list2;
                prev = prev.next;
                list2 = list2.next;
                prev.next = list1;
            } else {
                prev = prev.next;
                list1 = list1.next;
            }
        }
        if (list2 != null)
            prev.next = list2;
        return dummy.next;
    }
}