/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized
 * on OJ.
 * 
 * public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int
 * x) { val = x; } }
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        TreeNode p = root, tmp = null;
        while (p != null) {
            if (p.left == null) {
                result.add(p.val);
                p = p.right;
            } else {
                tmp = p.left;
                while (tmp.right != null && tmp.right != p)
                    tmp = tmp.right;
                if (tmp.right == null) {
                    tmp.right = p;
                    p = p.left;
                } else {
                    result.add(p.val);
                    tmp.right = null;
                    p = p.right;
                }
            }
        }
        return result;
    }
}