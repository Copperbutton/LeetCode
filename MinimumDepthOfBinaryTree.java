/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();

        int minDepth = 0;
        nodeQueue.offer(root);
        depthQueue.offer(1);

        while (!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();
            int currDepth = depthQueue.poll();

            if (currNode != null && currNode.left == null
                    && currNode.right == null) {
                minDepth = currDepth;
                break;
            }

            if (currNode != null && currNode.left != null) {
                nodeQueue.offer(currNode.left);
                depthQueue.offer(currDepth + 1);
            }

            if (currNode != null && currNode.right != null) {
                nodeQueue.offer(currNode.right);
                depthQueue.offer(currDepth + 1);
            }
        }
        return minDepth;
    }
}