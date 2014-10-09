/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * 
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>> ();
        Queue<TreeNode> nodes = new LinkedList<TreeNode> ();
        Queue<Integer> depths = new LinkedList<Integer> ();
        nodes.offer(root);
        depths.offer(0);
        while (!nodes.isEmpty()) {
            TreeNode currNode = nodes.poll();
            int currDepth = depths.poll();
            if (currNode == null)
                continue;
            
            if (levels.size() <= currDepth)
                levels.add(new LinkedList<Integer> ());
            if (0 == currDepth % 2)
                levels.get(currDepth).add(currNode.val);
            else
                levels.get(currDepth).add(0, currNode.val);
            
            nodes.offer(currNode.left);
            depths.offer(currDepth + 1);
            nodes.offer(currNode.right);
            depths.offer(currDepth + 1);
        }
        return levels;    }
}