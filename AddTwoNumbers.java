/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode p1 = l1, p2 = l2, p = dummy;
        while (p1 != null || p2 != null) {
            int sum = carry;
            sum += (p1 == null) ? 0 : p1.val;
            sum += (p2 == null) ? 0 : p2.val;
            ListNode newNode = new ListNode(sum % 10);
            p.next = newNode;
            p = p.next;
            if (p1 != null)
                p1 = p1.next;
            if (p2 != null)
                p2 = p2.next;
            carry = sum / 10;
        }
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            p.next = newNode;
        }
        return dummy.next;
    }
}