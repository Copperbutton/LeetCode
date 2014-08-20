/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 */
public class PalindromePartitionDFS {
    public List<List<String>> partition(String s) {
        int length = s.length();
        boolean[][] isValidPalind = new boolean[length][length];
        for (int left = length - 1; left >= 0; left--) {
            for (int right = left; right < length; right++) {
                isValidPalind[left][right] = ((s.charAt(left) == s
                        .charAt(right)) && (right - left < 2 || isValidPalind[left + 1][right - 1]));
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        findPartition(result, s, 0, isValidPalind, new LinkedList<String>());
        return result;
    }

    private void findPartition(List<List<String>> result, String s, int start,
            boolean[][] isValidPalind, LinkedList<String> path) {
        if (start == s.length()) {
            result.add(new LinkedList<String>(path));
            return;
        }

        for (int index = start; index < s.length(); index++) {
            if (isValidPalind[start][index]) {
                path.add(s.substring(start, index + 1));
                findPartition(result, s, index + 1, isValidPalind, path);
                path.removeLast();
            }
        }
    }
}