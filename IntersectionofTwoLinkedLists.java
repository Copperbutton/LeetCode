public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        while (headA != null && headB != null && headA != headB) {
            if (lenA == lenB) {
                headA = headA.next;
                headB = headB.next;
            } else if (lenA > lenB) {
                headA = headA.next;
                lenA --;
            } else {
                headB = headB.next;
                lenB --;
            }
        }
        
        return (headA == null || headB == null ? null : headA);
    }
    
    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len ++;
        }
        return len;
    }
}