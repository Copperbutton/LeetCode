/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ConvertSortedListToBinarySearchTreeBU {
    public TreeNode sortedListToBST(ListNode head) {
        List<ListNode> list = new ArrayList<ListNode> ();
        list.add(head);
        
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
            
        return sortedListToBST(list, 0, length - 1);
    }
    
    private TreeNode sortedListToBST(List<ListNode> head, int start, int end) {
        if (start > end)
            return null;
            
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(-1);
        root.left = sortedListToBST(head, start, mid - 1);
        
        ListNode node = head.get(0);
        root.val = node.val;
        head.set(0, node.next);
        root.right = sortedListToBST(head, mid + 1, end);
        return root;
    }
}