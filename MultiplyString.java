/**
 * Given two numbers represented as strings, return multiplication of the
 * numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 */

public class MultiplyString {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        int[] out = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            int digit1 = Integer.parseInt(num1.substring(i, i + 1));
            for (int j = len2 - 1; j >= 0; j--) {
                int digit2 = Integer.parseInt(num2.substring(j, j + 1));
                out[i + j + 1] += digit1 * digit2 + carry;
                carry = out[i + j + 1] / 10;
                out[i + j + 1] %= 10;
            }
            out[i] += carry;
        }

        StringBuilder builder = new StringBuilder();
        boolean firstZeros = true;
        for (int i = 0; i < len1 + len2; i++) {
            if (out[i] == 0 && i != len1 + len2 - 1) {
                if (!firstZeros)
                    builder.append(out[i]);
            } else {
                builder.append(out[i]);
                firstZeros = false;
            }
        }
        return builder.toString();
    }
}