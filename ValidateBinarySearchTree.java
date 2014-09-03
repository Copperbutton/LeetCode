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
        return isValidBSTRoot(root) && isValidBST(root.left)
                && isValidBST(root.right);
    }

    public boolean isValidBSTRoot(TreeNode root) {
        TreeNode tmp = null;
        boolean valid = true;
        if (root.left != null) {
            tmp = root.left;
            while (tmp.right != null)
                tmp = tmp.right;
            if (root.val <= tmp.val)
                valid = false;
        }

        if (root.right != null) {
            tmp = root.right;
            while (tmp.left != null)
                tmp = tmp.left;
            if (root.val >= tmp.val)
                valid = false;
        }

        return valid;
    }
}