/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 **/

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String> ();
        if (s != null)
            searchIPAddress(s, 0, new LinkedList<String> (), result);
        return result;
    }
    
    private void searchIPAddress(String s, int start, LinkedList<String> path, List<String> result) {
        if (start == s.length() || path.size() == 4) {
            if (start == s.length() && path.size() == 4) {
                result.add(concatList(path));
            }
            return;
        }
        
        for (int index = start; index < s.length() && index < start + 3; index ++) {
            String subStr = s.substring(start, index + 1);
            int value = Integer.parseInt(subStr);
            if (value > 255 || (subStr.length() > 1 && subStr.charAt(0) == '0'))
                return;
            path.add(subStr);
            searchIPAddress(s, index + 1, path, result);
            path.removeLast();
        }
    }
    
    private String concatList(List<String> list) {
        StringBuilder builder = new StringBuilder();
        for (String str : list) {
            builder.append(str);
            builder.append(".");
        }
        builder.setLength(builder.length() - 1);
        return builder.toString();
        
    }
}