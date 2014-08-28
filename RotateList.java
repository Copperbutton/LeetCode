/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
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

public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, curr = dummy, next = head;
        int count = 0;
        while (next != null) {
            next = next.next;
            count++;
        }
        n %= count;

        count = 0;
        next = dummy;
        while (next != null) {
            if (count > n)
                curr = curr.next;
            next = next.next;
            count++;
        }
        next = curr.next;

        while (prev != curr && next != null) {
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            prev = prev.next;
            next = curr.next;
        }
        return dummy.next;
    }
}