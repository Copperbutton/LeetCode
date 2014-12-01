public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            ListNode node = new ListNode(sum % 10);
            prev.next = node;
            prev = prev.next;
            sum /= 10;
        }
        
        if (sum > 0) {
            ListNode node = new ListNode(sum);
            prev.next = node;
        }
        
        return dummy.next;
    }
}