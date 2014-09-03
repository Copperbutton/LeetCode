/**
 * Given n, generate all structurally unique BST's (binary search trees) that
 * store values 1...n.
 * 
 * For example, Given n = 3, your program should return all 5 unique BST's shown
 * below. Definition for binary tree public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */

public class UniqueBinarySearchTreeII {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> subTrees = new ArrayList<TreeNode>();
        if (start > end) {
            subTrees.add(null);
            return subTrees;
        }

        for (int mid = start; mid <= end; mid++) {
            List<TreeNode> leftSubs = generateTrees(start, mid - 1);
            List<TreeNode> rightSubs = generateTrees(mid + 1, end);
            for (TreeNode left : leftSubs) {
                for (TreeNode right : rightSubs) {
                    TreeNode root = new TreeNode(mid);
                    root.left = left;
                    root.right = right;
                    subTrees.add(root);
                }
            }
        }
        return subTrees;
    }

}