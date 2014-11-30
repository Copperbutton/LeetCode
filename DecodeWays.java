/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 */

public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = s.length();
        int[] decodes = new int[len + 1];
        decodes[len] = 1;
        for (int i = len - 1; i >= 0; i--) {
            int num1 = s.charAt(i) - '0';
            decodes[i] = (num1 == 0 ? 0 : decodes[i + 1]);
            if (num1 == 0 || i == len - 1)
                continue;
            
            int num2 = num1 * 10 + s.charAt(i + 1) - '0';
            if (num2 > 0 && num2 <= 26)
                decodes[i] += decodes[i + 2];
        }
        return decodes[0];
    }
}