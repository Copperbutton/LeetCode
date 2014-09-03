/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *   /     /       \                 \
 *   2     1         2                 3
 */
public class Solution {
    public int numTrees(int n) {
        int[] bst = new int[n + 1];
        bst[0] = 1;
        bst[1] = 1;
        for (int i = 2; i <= n; i ++) {
            for (int j = 1; j <= i; j ++) {
                int tmp = bst[j - 1] * bst[i - j];
                bst[i] += tmp;
            }
        }
        return bst[n];
    }
}