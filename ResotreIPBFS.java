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
        Queue<List<String>> pathQueue = new LinkedList<List<String>>();
        Queue<Integer> indexQueue = new LinkedList<Integer>();
        pathQueue.offer(new ArrayList<String>());
        indexQueue.offer(0);
        while (!pathQueue.isEmpty()) {
            List<String> currPath = pathQueue.poll();
            int currIndex = indexQueue.poll();
            if (currPath.size() == 4) {
                if (currIndex == s.length())
                    result.add(converToIPAddress(currPath));
                continue;
            }

            for (int i = currIndex + 1; i <= s.length() && i <= currIndex + 3; i++) {
                String nextAddr = s.substring(currIndex, i);
                if (isValidIPAddress(nextAddr)) {
                    List<String> nextPath = new ArrayList<String>(currPath);
                    nextPath.add(nextAddr);
                    pathQueue.offer(nextPath);
                    indexQueue.offer(i);
                }
            }
        }

        return result;
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