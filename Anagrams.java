/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 */

public class Anagrams {
            Map<String, List<String>> map = new HashMap<String, List<String>> ();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String newStr = new String(chs);
            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList<String> ());
            }
            map.get(newStr).add(str);
        }
        
        List<String> result = new ArrayList<String>();
        for (String str : map.keySet()) {
            List<String> list = map.get(str);
            if (list.size()  > 1)
                result.addAll(list);
        }
        return result;
    }
}