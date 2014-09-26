/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 */

public class AddBinary {
public String addBinary(String a, String b) {
        if (a == null || b == null)
            return a == null ? b : a;
        int aLen = a.length();
        int bLen = b.length();
        char[] ret = new char[Math.max(aLen, bLen) + 1];
        int indexA = aLen - 1;
        int indexB = bLen - 1;
        int indexS = ret.length - 1;
        int carry = 0;
        while (indexA >= 0 || indexB >= 0 || indexS >= 0) {
            int sum = carry;
            if (indexA >= 0)
                sum += (a.charAt(indexA--) - '0');
            if (indexB >= 0)
                sum += (b.charAt(indexB--) - '0');
            ret[indexS--] = (char)('0' + sum % 2);
            carry = sum/2;
        }
        if (ret[0] == '0')
            ret = Arrays.copyOfRange(ret, 1, ret.length);
        return new String(ret);
    }
}