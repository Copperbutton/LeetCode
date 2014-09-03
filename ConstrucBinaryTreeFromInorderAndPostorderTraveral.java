/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ConstrucBinaryTreeFromInorderAndPostorderTraveral {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, slow = head, fast = head.next == null ? null
                : head.next;
        while (fast != null && fast.next != null) {
            prev = prev.next;
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }

        TreeNode root = new TreeNode(slow.val);
        prev.next = null;
        root.left = sortedListToBST(dummy.next);

        prev = slow;
        slow = slow.next;
        prev.next = null;
        root.right = sortedListToBST(slow);
        return root;
    }
}