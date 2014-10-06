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
        int decode[] = new int[len + 1];
        decode[len] = 1;
        decode[len - 1] = isDecodable(s.substring(len - 1, len)) ? 1 : 0;
        for (int i = len - 2; i>= 0; i--) {
            decode[i] += isDecodable(s.substring(i, i+1)) ? decode[i + 1] : 0;
            decode[i] += isDecodable(s.substring(i, i + 2)) ? decode[i + 2] : 0;
        }
        return decode[0];
    }
    
    private boolean isDecodable(String p){
        if (p.length() == 1)
            return p.charAt(0) >= '1' && p.charAt(0) <= '9';
        else {
            int value = Integer.parseInt(p);
            return p.charAt(0) != '0' &&  value >= 1 && value <= 26; 
        }
    }
}