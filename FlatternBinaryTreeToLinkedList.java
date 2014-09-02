/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class FlatternBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode curr = root, tmp = null;
        while (curr != null) {
            if (curr.left != null){
                tmp = curr.left;
                while (tmp.right != null)
                    tmp = tmp.right;
                tmp.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}