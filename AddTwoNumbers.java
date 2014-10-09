/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (first != null || second != null) {
            int sum = carry;
            sum += first == null ? 0 : first.val;
            sum += second == null ? 0 : second.val;
            if (first != null) {
                first.val = sum % 10;
                head = l1;
                tail = first;
                first = first.next;
            }
            if (second != null) {
                second.val = sum % 10;
                head = l2;
                tail = second;
                second = second.next;
            }
            carry = sum / 10;
        }
        if (carry != 0 && tail != null)
            tail.next = new ListNode(carry);
        return head;
    }
}