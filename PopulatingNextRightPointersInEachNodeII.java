/**Given a binary tree
 *  struct TreeLinkNode {
 *  TreeLinkNode *left;
 *  TreeLinkNode *right;
 *  TreeLinkNode *next;
 *  }
 *  
 *  Follow up for problem "Populating Next Right Pointers in Each Node".
 *  
 *  What if the given tree could be any binary tree? Would your previous solution still work?
 *  
 *  Note:
 *  
 *  You may only use constant extra space.
 *  You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 *  For example,
 *  Given the following perfect binary tree,
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 *       1 -> NULL
 *     /  \
 *    2 -> 3 -> NULL
 *   / \  / \
 *  4->5->6->7 -> NULL
 *  
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 *
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        TreeLinkNode dummy = new TreeLinkNode(-1);
        for (TreeLinkNode prev = dummy, curr = root; curr != null; curr = curr.next) {
            if (curr.left != null) {
                prev.next = curr.left;
                prev = curr.left;
            }
            if (curr.right != null) {
                prev.next = curr.right;
                prev = curr.right;
            }
        }
        connect(dummy.next);
    }
}