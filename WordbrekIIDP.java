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
public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        int len = s.length();
        boolean breakable[] = new boolean[len + 1];
        breakable[len] = true;
        boolean breakRecord[][] = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                String substring = s.substring(i, j+ 1);
                if(dict.contains(substring) && breakable[j + 1]) {
                    breakable[i] = true;
                    breakRecord[i][j] = true;
                }
            }
        }
        breakWord(s, breakRecord, new LinkedList<String> (), result, 0);
        return result;
    }
    
    private void breakWord(String s, boolean[][] breakRecord, LinkedList<String> path, List<String> result, int start) {
        if (start == s.length()) {
            StringBuilder builder = new StringBuilder();
            if (path.size() > 0) {
                for (String p : path) {
                    builder.append(p);
                    builder.append(" ");
                }
                builder.setLength(builder.length() - 1);
            }
            result.add(builder.toString());
            return;
        }
        
        for (int index = start; index < s.length(); index++) {
            if (breakRecord[start][index]) {
                path.addLast(s.substring(start, index + 1));
                breakWord(s, breakRecord, path, result, index + 1);
                path.removeLast();
            }
        }
    }
    
}
}