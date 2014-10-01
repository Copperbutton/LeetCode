/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        TreeNode prev = findPrev(root);
        if (prev != null && prev.val >= root.val)
            return false;
        TreeNode next = findNext(root);
        if (next != null && next.val <= root.val)
            return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
    
    private TreeNode findPrev(TreeNode root) {
        if (root == null || root.left == null)
            return null;
        TreeNode tmp = root.left;
        while (tmp.right != null)
            tmp = tmp.right;
        return tmp;
    }
    
    private TreeNode findNext(TreeNode root) {
        if (root == null || root.right == null)
            return null;
        TreeNode tmp = root.right;
        while (tmp.left != null)
            tmp = tmp.left;
        return tmp;
    }
}