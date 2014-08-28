/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 */

public class SingleNumberII {
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for (int a : A) {
            ones = (ones ^ a) & ~twos;
            twos = (twos ^ a) & ~ones;
        }
        return ones;
    }
}