/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
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

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        dummy.next = l1;
        ListNode prev = dummy, p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                prev.next = p2;
                p2 = p2.next;
                prev.next.next = p1;
                prev = prev.next;
            } else {
                prev = prev.next;
                p1 = p1.next;
            }
        }
        
        if (p2 != null)
            prev.next = p2;
        return dummy.next;
    }
}