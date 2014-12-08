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
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        
        char[] permuts = new char[n];
        for (int i = 0; i < n; i++)
            permuts[i] = (char)(i + '1');
        k = k - 1;
        for (int i = 0; i < n; i++) {
            int index = i + (k/ (factorial[n - 1 - i]));
            k %= factorial[n - 1 - i];
            if (index == i)
                continue;
            char tmp = permuts[i];
            permuts[i] = permuts[index];
            permuts[index] = tmp;
            Arrays.sort(permuts, i + 1, n);
        }
        
        return new String(permuts);
    }
}