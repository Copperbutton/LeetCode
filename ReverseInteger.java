/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 */

public class ReverseInteger {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE)
            return 0;
            
        boolean negative = x < 0;
        x = Math.abs(x);
        int newX = 0;
        while (x > 0) {
            if (newX > Integer.MAX_VALUE/10 || (newX == Integer.MAX_VALUE && x%10 > 7))
                return 0;
            newX = newX * 10 + x%10;
            x /= 10;
        }
        if (negative)
            newX = -newX;
        return newX;
    }
}