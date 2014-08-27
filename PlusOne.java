/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 */

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] newNum = new int[len + 1];
        newNum[len] = 1;
        for (int i = len - 1; i >= 0; i--) {
            int sum = newNum[i + 1] + digits[i];
            newNum[i + 1] = sum % 10;
            newNum[i] = sum / 10;
        }
        return newNum[0] == 0 ? Arrays.copyOfRange(newNum, 1, len + 1) : newNum;
    }
}