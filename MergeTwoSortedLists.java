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
        ListNode preInsert = dummy;
        ListNode curr = l2;
        while (curr != null) {
            while (preInsert.next != null && preInsert.next.val < curr.val)
                preInsert = preInsert.next;
            l2 = curr.next;
            curr.next = preInsert.next;
            preInsert.next = curr;
            preInsert = curr;
            curr = l2;
        }
        return dummy.next;
    }
}