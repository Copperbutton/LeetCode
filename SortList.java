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
        if (head == null || head.next == null)
            return head;
            
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        
        fast = slow.next;
        slow.next = null;
        head = sortList(head);
        fast = sortList(fast);
        return mergeSortedList(head, fast);
    }
    
    public ListNode mergeSortedList(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(-1);
        dummy.next = first;
        ListNode secondCurr = second;
        ListNode prevInsert = dummy;
        while (secondCurr != null) {
            while(prevInsert.next != null && prevInsert.next.val < secondCurr.val)
                prevInsert = prevInsert.next;
            second = second.next;
            secondCurr.next = prevInsert.next;
            prevInsert.next = secondCurr;
            secondCurr = second;
            prevInsert = prevInsert.next;
        }
        return dummy.next;
    }
}