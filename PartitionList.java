/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
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

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        dummy.next = head;
        while (prev.next != null && prev.next.val < x)
            prev = prev.next;

        ListNode curr = prev;            
        while (curr.next != null) {
            if (curr.next.val >= x)
                curr = curr.next;
            else {
                ListNode tmp = curr.next;
                curr.next = tmp.next;
                tmp.next = prev.next;
                prev.next = tmp;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}