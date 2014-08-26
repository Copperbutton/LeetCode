/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column. 1,2,3 → 1,3,2 3,2,1 →
 * 1,2,3 1,1,5 → 1,5,1
 */

public class NextPermutation {
    public void nextPermutation(int[] num) {
        int len = num.length;
        int excStartIndex = -1, excEndIndex = 0;
        for (int i = len - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (num[j] < num[i] && excStartIndex < j) {
                    excStartIndex = j;
                    excEndIndex = i;
                    break;
                }
            }
        }
        if (excStartIndex >= 0) {
            int tmp = num[excStartIndex];
            num[excStartIndex] = num[excEndIndex];
            num[excEndIndex] = tmp;
        }
        Arrays.sort(num, excStartIndex + 1, len);
    }
}