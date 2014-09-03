/**
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 *
 * For example:
 * Given the below binary tree,
 *
 *       1
 *      / \
 *     2   3
 * Return 6.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BinaryTreeMaximumPathSum {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return maxSum;
    }
    
    private int findMaxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        
        int left = findMaxPathSum(root.left);
        if (left < 0)
            left = 0;
            
        int right = findMaxPathSum(root.right);
        if (right < 0)
            right = 0;
        
        maxSum = Math.max(maxSum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}