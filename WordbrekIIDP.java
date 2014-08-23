/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand",
 * "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 */

public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] stringBreak = new boolean[len + 1];
        boolean[][] breakable = new boolean[len][len + 1];
        stringBreak[len] = true;

        for (int left = len - 1; left >= 0; left--) {
            for (int right = left + 1; right <= len; right++) {
                if (stringBreak[right]
                        && dict.contains(s.substring(left, right))) {
                    stringBreak[left] = true;
                    breakable[left][right] = true;
                    ;
                }
            }
        }
        List<String> result = new ArrayList<String>();
        breakWord(s, breakable, result, new LinkedList<String>(), 0);
        return result;
    }

    private void breakWord(String s, boolean[][] breakable,
            List<String> result, LinkedList<String> path, int index) {
        if (index == s.length()) {
            StringBuilder builder = new StringBuilder();
            if (path.size() > 0) {
                for (String p : path) {
                    builder.append(p);
                    builder.append(' ');
                }
                builder.setLength(builder.length() - 1);
            }
            result.add(builder.toString());
            return;
        }

        for (int start = index + 1; start <= s.length(); start++) {
            if (breakable[index][start]) {
                path.add(s.substring(index, start));
                breakWord(s, breakable, result, path, start);
                path.removeLast();
            }
        }
    }
}