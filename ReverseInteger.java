/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 */

public class ReverseInteger {
    public int reverse(int x) {
        int absX = Math.abs(x);
        int result = 0;
        while (absX > 0) {
            result *= 10;
            result += absX % 10;
            absX /= 10;
        }
        return x > 0 ? result : -result;
    }
}