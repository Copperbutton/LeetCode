/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 */

public class PermutationSequence {
public class Solution {
    public String getPermutation(int n, int k) {
        char[] array = new char[n];
        for (int i = 0; i < n; i++)
            array[i] = (char)(i + '1');
        k--;
        k %= getFactorial(n);
        for (int i = 0; i < n; i++) {
            int factoral = getFactorial(n - i - 1);
            int index = k/factoral;
            swap(array, i, i + index);
            Arrays.sort(array, i + 1, n);
            k %= factoral;
        }
        return new String(array);
    }
    
    public int getFactorial(int n) {
        int result = 1;
        while (n > 1)
            result *= n--;
        return result;
    }
    
    public void swap(char[] array, int first, int second) {
        char tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }
}