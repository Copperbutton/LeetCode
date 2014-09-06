/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

public class BinaryTreePostorderTraversalTwoStack {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> preorder = new Stack<TreeNode>();
        Stack<TreeNode> postorder = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        preorder.push(root);
        while (!preorder.isEmpty()) {
            TreeNode currNode = preorder.pop();
            if (currNode == null)
                continue;
            postorder.push(currNode);

            preorder.push(currNode.left);
            preorder.push(currNode.right);
        }

        while (!postorder.isEmpty()) {
            TreeNode currNode = postorder.pop();
            result.add(currNode.val);
        }

        return result;
    }
}