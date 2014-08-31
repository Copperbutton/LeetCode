/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 */

public class CountAndSay {
    public String countAndSay(int n) {
        String say = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            char[] chs = say.toCharArray();
            for (int j = 0; j < chs.length;) {
                char ch = chs[j++];
                int count = 1;
                while (j < chs.length && chs[j] == chs[j - 1]) {
                    count++;
                    j++;
                }
                builder.append(count);
                builder.append(ch);
            }
            say = builder.toString();
        }
        return say;
    }
}