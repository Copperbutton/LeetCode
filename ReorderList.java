/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
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

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode p1 = head, p2 = (head == null) ? null : head.next;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
            p2 = p2.next;
        }
        ListNode head2 = p1.next;
        p1.next = null;
        p1 = head;
        head2 = reverseList(head2);

        while (head2 != null) {
            p2 = head2;
            head2 = head2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head, next = (head == null) ? null : head.next;
        while (next != null) {
            curr.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
            next = curr.next;
        }
        return dummy.next;
    }
}