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
        List<String> result = new ArrayList<String>();
        findValidIPAddress(s, result, 0, 0, new LinkedList<String>());
        return result;
    }

    private void findValidIPAddress(String s, List<String> result,
            int startIndex, int depth, LinkedList<String> path) {
        if (depth == 4) {
            if (startIndex == s.length())
                result.add(converToIPAddress(path));
            return;
        }

        for (int index = startIndex + 1; index <= s.length()
                && index <= startIndex + 3; index++) {
            String nextAddr = s.substring(startIndex, index);
            if (isValidIPAddress(nextAddr)) {
                path.add(nextAddr);
                findValidIPAddress(s, result, index, depth + 1, path);
                path.removeLast();
            }
        }
    }

    private boolean isValidIPAddress(String addr) {
        if (addr.length() > 3 || (addr.startsWith("0") && addr.length() > 1))
            return false;

        int valueOfAddr = Integer.parseInt(addr);
        return (valueOfAddr >= 0 && valueOfAddr <= 255);
    }

    private String converToIPAddress(List<String> path) {
        StringBuilder builder = new StringBuilder();
        for (String p : path) {
            builder.append(p);
            builder.append(".");
        }
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }
}