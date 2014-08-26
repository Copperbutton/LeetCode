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
    public String getPermutation(int n, int k) {
        int[] factorialArray = getFactorialArray(n - 1);
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++)
            permutation[i] = i + 1;

        k -= 1;
        for (int i = 0; i < n; i++) {
            int index = k / factorialArray[n - 1 - i];
            int tmp = permutation[i];
            permutation[i] = permutation[i + index];
            permutation[i + index] = tmp;
            k = k % factorialArray[n - 1 - i];
            Arrays.sort(permutation, i + 1, n);
        }

        StringBuilder builder = new StringBuilder();
        for (int digit : permutation)
            builder.append(digit);
        return builder.toString();
    }

    private int[] getFactorialArray(int n) {
        int[] factorialArray = new int[n + 1];
        factorialArray[0] = 1;
        for (int i = 1; i <= n; i++)
            factorialArray[i] = i * factorialArray[i - 1];
        return factorialArray;
    }
}