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
        int length = s.length();
        if (length == 0)
            return 0;

        int[] numDecode = new int[length + 1];
        numDecode[length] = 1;
        numDecode[length - 1] = decodeAble(s.substring(length - 1, length)) ? 1 : 0;
        for (int i = length - 2; i >= 0; i--) {
            if (!decodeAble(s.substring(i, i + 1)))
                numDecode[i] = 0;
            else
                numDecode[i] = decodeAble(s.substring(i, i + 2)) ? (numDecode[i + 1] + numDecode[i + 2]) : numDecode[i + 1];
        }
        return numDecode[0];
    }

    private boolean decodeAble(String code) {
        if (code.length() == 1 && Integer.parseInt(code) > 0)
            return true;
        if (code.length() == 2 && code.charAt(0) != '0'
                && Integer.parseInt(code) <= 26)
            return true;
        return false;
    }
}