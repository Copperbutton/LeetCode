/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 *  
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ConstructBianryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        while (index < length && preorder[0] != inorder[index])
            index++;

        if (index == 0)
            root.left = null;
        else
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));

        if (index + 1 < length)
            root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, length), Arrays.copyOfRange(inorder, index + 1, length));
        else
            root.right = null;

        return root;
    }
}