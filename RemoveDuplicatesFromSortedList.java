/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * Definition for singly-linked list.
 *
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = head, end = head;
        while (end != null) {
            while(end != null && end.val == start.val)
                end = end.next;
            start.next = end;
            start = end;
        }
        return head;
    }
}