/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class MinimumDepthOfBinaryTreeR {
    public int minDepth(TreeNode root) {
        return findMinDepth(root);
    }

    private int findMinDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        int left = findMinDepth(root.left);
        int right = findMinDepth(root.right);

        int minDepth = Integer.MAX_VALUE;
        if (left > 0)
            minDepth = Math.min(minDepth, left);
        if (right > 0)
            minDepth = Math.min(minDepth, right);
        return minDepth + 1;
    }
}