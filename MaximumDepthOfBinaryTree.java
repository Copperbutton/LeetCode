/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public int maxDepth(TreeNode root) {
        return findMaxDepth(root);
    }
    
    private int findMaxDepth(TreeNode root) {
        if (root == null)
            return 0;
        
        if (root.left == null && root.right == null)
            return 1;
        
        int left = findMaxDepth(root.left);
        int right = findMaxDepth(root.right);
        
        int max = 0;
        if (left > 0)
            max = Math.max(max, left);
        if (right > 0)
            max = Math.max(max, right);
        return max + 1;
    }
}