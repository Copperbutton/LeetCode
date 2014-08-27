/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 */

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] stepToTop = new int[n + 1];
        stepToTop[n] = 1;
        stepToTop[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--)
            stepToTop[i] = stepToTop[i + 1] + stepToTop[i + 2];
        return stepToTop[0];
    }
}