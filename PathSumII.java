/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *              5
 *             / \
 *            4   8
 *           /   / \
 *          11  13  4
 *         /  \    / \
 *        7    2  5   1
 * return
 * [
 *   [5,4,11,2],
 *   [5,8,4,5]
 * ]
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        findPathSum(root, sum, result, new LinkedList<Integer>());
        return result;
    }
    
    private void findPathSum(TreeNode root, int sum, List<List<Integer>> result, LinkedList<Integer> path) {
        if (root == null)
            return;
            
        if (root.val == sum && root.left == null && root.right == null) {
            path.addLast(root.val);
            result.add(new LinkedList<Integer> (path));
            path.removeLast();
            return;
        }
        
        path.addLast(root.val);
        findPathSum(root.left, sum - root.val, result, path);
        findPathSum(root.right, sum - root.val, result, path);
        path.removeLast();
    }
}