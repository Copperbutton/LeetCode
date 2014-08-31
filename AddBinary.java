/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        char[] aChs = a.toCharArray(), bChs = b.toCharArray();
        int resultLen = Math.max(a.length(), b.length()) + 1;
        char[] result = new char[resultLen];
        Arrays.fill(result, '0');

        int carry = 0;
        int aIndx = aChs.length - 1, bIndx = bChs.length - 1, rIndx = resultLen - 1;
        while (aIndx >= 0 || bIndx >= 0 || rIndx >= 0) {
            int sum = carry;
            if (aIndx >= 0)
                sum += aChs[aIndx--] - '0';
            if (bIndx >= 0)
                sum += bChs[bIndx--] - '0';
            result[rIndx--] += sum % 2;
            carry = sum / 2;
        }
        return new String(result[0] == '0' ? Arrays.copyOfRange(result, 1,
                resultLen) : result);
    }
}