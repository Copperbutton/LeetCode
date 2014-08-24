/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 */

public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        for (; x != 0; x /= 10) {
            result = result * 10 + x % 10;
        }
        return result;
    }
}a