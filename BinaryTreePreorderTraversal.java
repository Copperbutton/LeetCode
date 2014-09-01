/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively? Definition
 * for binary tree public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode p = root, tmp = root;
        while (p != null) {
            if (p.left == null) {
                list.add(p.val);
                p = p.right;
            } else {
                tmp = p.left;
                while (tmp.right != null && tmp.right != p)
                    tmp = tmp.right;
                if (tmp.right == null) {
                    list.add(p.val);
                    tmp.right = p;
                    p = p.left;
                } else {
                    tmp.right = null;
                    p = p.right;
                }
            }
        }
        return list;
    }
}
