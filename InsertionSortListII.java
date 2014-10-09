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

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = head;
        while (head != null) {
            ListNode preInsert = findPreInsert(dummy, head.val);
            head = head.next;
            curr.next = preInsert.next;
            preInsert.next = curr;
            curr = head;
        }
        return dummy.next;
    }
    
    private ListNode findPreInsert(ListNode preHead, int val) {
        ListNode preInsert = preHead;
        while (preInsert.next != null && preInsert.next.val < val)
            preInsert = preInsert.next;
        return preInsert;
    }
}