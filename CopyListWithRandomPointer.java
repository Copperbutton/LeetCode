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
        RandomListNode p1 = head;
        while (p1 != null) {
            RandomListNode newNode = new RandomListNode(p1.label);
            newNode.next = p1.next;
            p1.next = newNode;
            p1 = newNode.next;
        }

        p1 = head;
        while (p1 != null) {
            RandomListNode next = p1.next;
            next.random = (p1.random == null) ? null : p1.random.next;
            p1 = next.next;
        }

        p1 = head;
        RandomListNode head2 = (head == null) ? null : head.next, p2 = head2;
        while (p1 != null) {
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1 == null ? null : p1.next;
            p2 = p1 == null ? null : p2.next;
        }

        return head2;
    }
}