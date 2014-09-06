/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

public class BinaryTreePostorderTraversalOneStack {
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode p = root, q = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        while (p != null) {
            for (; p.left != null; p = p.left)
                stack.push(p);
            while (p != null && (p.right == null || p.right == q)) {
                result.add(p.val);
                q = p;
                if (stack.isEmpty())
                    return result;
                p = stack.pop();
            }
            stack.push(p);
            p = p.right;
        }
    }
}