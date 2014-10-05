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
        int size = getSize(head);
        n %= size;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        
        int count = 0;
        /** 
         * Here use next != null instead of second != null, so that
         * can insert front directly.
         */
        while (second.next != null) {
            if (count >= n)
                first = first.next;
            second = second.next;
            count ++;
        }
        
	/** Incase count n == 0*/
        if (first != second) {
            ListNode head2 = first.next;
            first.next = null;
            second.next = dummy.next;
            dummy.next = head2;
        }
        return dummy.next;
    }
    
    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
}