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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0)
            return null;
        TreeNode root = new TreeNode(postorder[len - 1]);
        int index = 0;
        while (index < len && inorder[index] != postorder[len - 1])
            index ++;
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(inorder, index + 1, len), Arrays.copyOfRange(postorder, index, len - 1));
        return root;
    }
}