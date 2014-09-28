/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return buildBST(head);
    }

    private TreeNode buildBST(ListNode head) {
        if (head == null)
            return null;
        ListNode prevMid = findPrevMid(head);
        ListNode mid = prevMid.next;
        prevMid.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = buildBST(mid == head ? null : head);
        root.right = buildBST(mid.next);
        return root;
    }

    private ListNode findPrevMid(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = head == null ? null : head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        return slow;
    }
}