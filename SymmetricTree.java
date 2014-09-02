/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree is symmetric:
 * 
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 
 * But the following is not:
 * 
 *   1
 *  / \
 * 2   2
 * \   \
 * 3    3
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode> ();
        boolean symmetric = true;
        if (root != null) {
            queue.offer(root.left);
            queue.offer(root.right);
        }
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.isEmpty() ? null : queue.poll();
            if (t1 == null && t2 == null)
                continue;
            
            if (t1 == null || t2 == null) {
                symmetric = false;
                break;
            }
            
            if (t1.val != t2.val) {
                symmetric = false;
                break;
            }
            
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return symmetric;
    }
}