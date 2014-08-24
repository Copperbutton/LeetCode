/**
 * You are given a string, S, and a list of words, L, that are all of the same
 * length. Find all starting indices of substring(s) in S that is a
 * concatenation of each word in L exactly once and without any intervening
 * characters.
 * 
 * For example, given: S: "barfoothefoobarman" L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 */

public class SubstringWithConcatenationofAllWords {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        int lSize = L.length;
        if (lSize == 0)
            return result;
        int lLen = L[0].length();
        Map<String, Integer> expected = new HashMap<String, Integer>();
        Map<String, Integer> found = new HashMap<String, Integer>();
        for (String s : L) {
            int count = 1;
            if (expected.containsKey(s))
                count = expected.get(s) + 1;
            else
                found.put(s, 0);
            expected.put(s, count);
        }

        for (int start = 0; start <= S.length() - lSize * lLen; start++) {
            int count = 0;
            for (int i = 0; i < lSize; i++) {
                String sub = S.substring(start + i * lLen, start + (i + 1)
                        * lLen);
                if (expected.containsKey(sub)
                        && found.get(sub) < expected.get(sub)) {
                    count++;
                    found.put(sub, found.get(sub) + 1);
                } else
                    break;
            }
            if (count == lSize) {
                result.add(start);
            }
            if (count > 0) {
                for (String str : found.keySet())
                    found.put(str, 0);
            }
        }
        return result;
    }
}