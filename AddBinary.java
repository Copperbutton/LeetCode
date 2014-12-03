/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || b == null)
            return a == null ? b : a;
        char[] res = new char[Math.max(a.length(), b.length()) + 1];
        int i = a.length() - 1;
        int j = b.length() - 1;
        int k = res.length - 1;
        for(int sum = 0; k >= 0; sum /= 2) {
            if (i >= 0)
                sum += (a.charAt(i--) - '0');
            if (j >= 0)
                sum += (b.charAt(j--) - '0');
            res[k --] = (char)(sum % 2 + '0');
        }
        
        if (res[0] == '0')
            res = Arrays.copyOfRange(res, 1, res.length);
        return new String(res);
    }
}