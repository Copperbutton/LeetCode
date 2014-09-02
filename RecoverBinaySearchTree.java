/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note: A solution using O(n) space is pretty straight forward. Could you
 * devise a constant space solution? confused what "{1,#,2,3}" means? Definition
 * for binary tree public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */

public class RecoverBinaySearchTree {
    public void recoverTree(TreeNode root) {
        TreeNode p = root, prev = null, tmp = null;
        TreeNode exc1 = null, exc2 = null;
        while (p != null) {
            if (p.left == null) {
                prev = p;
                p = p.right;
            } else {
                tmp = p.left;
                while (tmp.right != null && tmp.right != p)
                    tmp = tmp.right;

                if (tmp.right == null) {
                    tmp.right = p;
                    p = p.left;
                } else {
                    tmp.right = null;
                    prev = p;
                    p = p.right;
                }
            }

            if (prev != null && p != null && prev.val > p.val) {
                if (exc1 == null) {
                    exc1 = prev;
                    exc2 = p;
                } else {
                    exc2 = p;
                }
            }
        }

        int tmpVal = exc1.val;
        exc1.val = exc2.val;
        exc2.val = tmpVal;
    }
}