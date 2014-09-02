/**Given a binary tree
 *  struct TreeLinkNode {
 *  TreeLinkNode *left;
 *  TreeLinkNode *right;
 *  TreeLinkNode *next;
 *  }
 *  
 *  Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *  
 *  Initially, all next pointers are set to NULL.
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
 */

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> nodeQueue = new LinkedList<TreeLinkNode> ();
        Queue<Integer> levelQueue = new LinkedList<Integer> ();
        nodeQueue.offer(root);
        levelQueue.offer(0);
        TreeLinkNode prevNode = null;
        int prevLevel = -1;
        while(!nodeQueue.isEmpty()) {
            TreeLinkNode currNode = nodeQueue.poll();
            int currLevel = levelQueue.poll();
            
            if (currNode == null)
                continue;
            
            if (prevLevel == currLevel) {
                prevNode.next = currNode;
            } else {
                prevLevel = currLevel;
            }
            prevNode = currNode;
            
            nodeQueue.offer(currNode.left);
            levelQueue.offer(currLevel + 1);
            nodeQueue.offer(currNode.right);
            levelQueue.offer(currLevel + 1);
        }
    }
}