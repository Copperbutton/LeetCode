/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 */

public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        Map<String, List<String>> found = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String newStr = new String(chs);
            if (found.containsKey(newStr)) {
                found.get(newStr).add(str);
            } else {
                List<String> newList = new ArrayList<String>();
                newList.add(str);
                found.put(newStr, newList);
            }
        }

        for (String str : found.keySet()) {
            List<String> list = found.get(str);
            if (list.size() > 1)
                result.addAll(list);
        }
        return result;
    }
}