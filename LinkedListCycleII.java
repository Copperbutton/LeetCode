/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
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

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visitedNodes = new HashSet<ListNode>();
        ListNode detector = head;
        while (detector != null) {
            if (visitedNodes.contains(detector))
                break;
            visitedNodes.add(detector);
            detector = detector.next;
        }
        return detector;
    }
}