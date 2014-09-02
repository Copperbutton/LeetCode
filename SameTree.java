/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        boolean sameTree = true;
        stack1.push(p);
        stack2.push(q);
        while (!stack1.isEmpty()) {
            TreeNode pCurr = stack1.pop();
            TreeNode qCurr = stack2.pop();

            if (pCurr == null && qCurr == null)
                continue;
            if (pCurr == null || qCurr == null) {
                sameTree = false;
                break;
            }
            if (pCurr.val != qCurr.val) {
                sameTree = false;
                break;
            }

            stack1.push(pCurr.left);
            stack1.push(pCurr.right);
            stack2.push(qCurr.left);
            stack2.push(qCurr.right);
        }
        return sameTree;
    }
}