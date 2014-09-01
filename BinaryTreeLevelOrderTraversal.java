/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * For example:
 * 
 * Given binary tree {3,9,20,#,#,15,7},
 *  3
 *  / \
 *  9  20
 *  /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * 
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> levelQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        levelQueue.offer(0);
        while (root != null && !nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();
            int currLevel = levelQueue.poll();
            if (levels.size() <= currLevel) {
                List<Integer> newLevel = new ArrayList<Integer>();
                levels.add(newLevel);
            }
            levels.get(currLevel).add(currNode.val);

            if (currNode.left != null) {
                nodeQueue.offer(currNode.left);
                levelQueue.offer(currLevel + 1);
            }

            if (currNode.right != null) {
                nodeQueue.offer(currNode.right);
                levelQueue.offer(currLevel + 1);
            }
        }
        return levels;
    }
}