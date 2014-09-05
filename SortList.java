/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class SortList {
    public ListNode sortList(ListNode head) {
        ListNode slow = head, fast = head == null ? null : head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }

        if (slow != null && slow.next != null) {
            fast = slow.next;
            slow.next = null;
            ListNode p1 = sortList(head);
            ListNode p2 = sortList(fast);
            head = mergeSortedList(p1, p2);
        }
        return head;
    }

    private ListNode mergeSortedList(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(-1);
        dummy.next = first;
        ListNode prev = dummy;
        while (first != null && second != null) {
            if (second.val < first.val) {
                prev.next = second;
                second = second.next;
                prev = prev.next;
                prev.next = first;
            } else {
                prev = prev.next;
                first = first.next;
            }
        }
        if (second != null)
            prev.next = second;

        return dummy.next;
    }
}