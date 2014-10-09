/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * 
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;
        
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode newNode = new RandomListNode(curr.label);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        
        curr = head;
        RandomListNode next = head.next;
        while (curr != null) {
            next.random = curr.random == null ? null : curr.random.next;
            curr = next.next;
            next = curr == null ? null : curr.next;
        }
        
        RandomListNode dummy = new RandomListNode(-1);
        dummy.next = head.next;
        curr = head;
        next = head.next;
        while (curr != null) {
            curr.next = next.next;
            curr = curr.next;
            next.next = curr == null ? null : curr.next;
            next = next.next;
        }
        
        return dummy.next;
    }
}