/**
 * Sort a linked list using insertion sort.
 * 
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

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = head, curr = (head == null) ? null : head.next, insert = dummy;
        while (curr != null) {
            insert = dummy;
            while (insert.next.val < curr.val)
                insert = insert.next;

            if (insert == prev) {
                prev = prev.next;
            } else {
                prev.next = curr.next;
                curr.next = insert.next;
                insert.next = curr;
            }
            curr = prev.next;
        }
        return dummy.next;
    }
}