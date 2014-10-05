/**
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

public class MergeKSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        while (lists != null && lists.size() > 1) {
            int left = 0;
            int right = lists.size() - 1;
            List<ListNode> newLists = new ArrayList<ListNode> ();
            while (left < right) {
                ListNode newNode = mergeTwoLists(lists.get(left ++), lists.get(right --));
                newLists.add(newNode);
            }
            if (left == right)
                newLists.add(lists.get(left));
            lists = newLists;
        }
        return lists == null || lists.size() == 0 ? null : lists.get(0);
    }
    
    private ListNode mergeTwoLists(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(-1);
        dummy.next = one;
        ListNode pOne = dummy;
        ListNode pTwo = two;
        while (pTwo != null) {
            two = two.next;
            while (pOne.next != null && pOne.next.val < pTwo.val)
                pOne = pOne.next;
            pTwo.next = pOne.next;
            pOne.next = pTwo;
            pTwo = two;
        }
        return dummy.next;
    }
}