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
        List<Integer> indexs = new ArrayList<Integer> ();
        if (L.length == 0)
            return indexs;
            
        Map<String, Integer> expected = new HashMap<String, Integer> ();
        Map<String, Integer> found = new HashMap<String, Integer>();
        for (String str : L) {
            int count = 1;
            if (expected.containsKey(str))
                count = expected.get(str) + 1;
            expected.put(str, count);
        }
        initMap(found, L);
        
        int len = L[0].length();
        int concatLen = len * L.length;
        for (int start = 0; start <= S.length() - concatLen; start ++) {
            int offset = 0;
            while(offset < concatLen) {
                String target = S.substring(start + offset, start + offset + len);
                if (!expected.containsKey(target) || found.get(target) >= expected.get(target))
                    break;
                found.put(target, found.get(target) + 1);
                if (offset + len == concatLen)
                    indexs.add(start);
                offset += len;
            }
            if (offset > 0)
                initMap(found, L);
        }
        return indexs;
    }
    
    private void initMap(Map<String, Integer> map, String[] L) {
        for (String str : L)
            map.put(str, 0);
    }
}
}