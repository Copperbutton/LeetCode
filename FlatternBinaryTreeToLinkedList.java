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
        if (root == null)
            return;
        List<TreeNode> preorder = new ArrayList<TreeNode> ();
        preorder.add(root);
        flattern(root, preorder);
    }
    
    private void flattern(TreeNode root, List<TreeNode> preorder) {
        if (root.left == null && root.right == null) {
            preorder.clear();
            preorder.add(root);
            return;
        }
        
        if (root.left != null) {
            flattern(root.left, preorder);
            preorder.get(0).right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if (root.right != null)
            flattern(root.right, preorder);
    }
}