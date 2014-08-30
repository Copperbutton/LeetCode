/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
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

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = (head == null) ? null : head.next;
        boolean hasCycle = false;
        while (fast != null) {
            if (fast == slow) {
                hasCycle = true;
                break;
            }
            slow = slow.next;
            fast = fast.next;
            fast = (fast == null) ? null : fast.next;
        }
        return hasCycle;
    }
}