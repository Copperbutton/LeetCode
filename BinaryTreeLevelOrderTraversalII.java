/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example:
 * 
 * Given binary tree {3,9,20,#,#,15,7},
 *  3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 *  return its bottom-up level order traversal as:
 *  [
 *  [15,7],
 *  [9,20],
 *  [3]
 *  ]
 *  
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> levels = new LinkedList<List<Integer>>();
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode> ();
        Queue<Integer> levelQueue = new LinkedList<Integer> ();
        nodeQueue.offer(root);
        levelQueue.offer(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();
            int currLevel = levelQueue.poll();
            
            if (currNode == null)
                continue;
                
            if (levels.size() <= currLevel) {
                List<Integer> newLevel = new ArrayList<Integer> ();
                levels.addFirst(newLevel);
            }
            levels.get(0).add(currNode.val);
            
            nodeQueue.offer(currNode.left);
            levelQueue.offer(currLevel + 1);
            nodeQueue.offer(currNode.right);
            levelQueue.offer(currLevel + 1);
        }
        return levels;
    }
}