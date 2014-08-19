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
public class PalindromePartitionBFSWithItemScan {
    public List<List<String>> partition(String s) {
        int length = s.length();
        boolean[][] isValidPalind = new boolean[length][length];
        for (int left = length - 1; left >= 0; left--) {
            for (int right = left; right < length; right++) {
                isValidPalind[left][right] = ((s.charAt(left) == s
                        .charAt(right)) && (right - left < 2 || isValidPalind[left + 1][right - 1]));
            }
        }

        Queue<Map<Integer, List<String>>> queue = new LinkedList<Map<Integer, List<String>>>();
        Map<Integer, List<String>> start = new HashMap<Integer, List<String>>();
        start.put(0, new ArrayList<String>());
        queue.offer(start);
        List<List<String>> result = new ArrayList<List<String>>();
        while (!queue.isEmpty()) {
            Map<Integer, List<String>> nextMap = queue.poll();
            for (int index : nextMap.keySet()) {
                List<String> currPath = nextMap.get(index);
                for (int i = index; i < s.length(); i++) {
                    if (isValidPalind[index][i]) {
                        List<String> newPath = new ArrayList<String>(currPath);
                        newPath.add(s.substring(index, i + 1));
                        Map<Integer, List<String>> newMap = new HashMap<Integer, List<String>>();
                        newMap.put(i + 1, newPath);
                        queue.offer(newMap);
                    }
                }
                if (index == s.length())
                    result.add(currPath);
            }
        }
        return result;
    }
}