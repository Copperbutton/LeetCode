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
        List<List<Integer>> levels = new ArrayList<List<Integer>> ();
        Queue<TreeNode> nodes = new LinkedList<TreeNode> ();
        Queue<Integer> depth = new LinkedList<Integer> ();
        nodes.offer(root);
        depth.offer(0);
        while (!nodes.isEmpty()) {
            TreeNode currNode = nodes.poll();
            int currDepth = depth.poll();
            if (currNode == null)
                continue;
            
            if (levels.size() <= currDepth)
                levels.add(new ArrayList<Integer> ());
            levels.get(currDepth).add(currNode.val);
            
            nodes.offer(currNode.left);
            depth.offer(currDepth + 1);
            nodes.offer(currNode.right);
            depth.offer(currDepth + 1);
        }
        return levels;
    }
}