/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * 
 * For example,
 * 
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * 
 * Given 1->1->1->2->3, return 2->3.
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
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, start = head, end = head;
        while (end != null) {
            while (end != null && end.val == start.val)
                end = end.next;
            if (start.next == end) {
                prev = prev.next;
                start = start.next;
            } else {
                prev.next = end;
                start = end;
            }
        }
        return dummy.next;
    }
}