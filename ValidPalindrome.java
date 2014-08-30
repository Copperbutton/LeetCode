/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null)
            return false;
        s = s.toLowerCase();
        char[] chs = s.toCharArray();
        boolean isValidPalindrome = true;
        for (int left = 0, right = chs.length - 1; left <= right;) {
            char leftCh = chs[left];
            char rightCh = chs[right];
            if (!((leftCh >= 'a' && leftCh <= 'z') || (leftCh >= '0' && leftCh <= '9')))
                left++;
            else if (!((rightCh >= 'a' && rightCh <= 'z') || (rightCh >= '0' && rightCh <= '9')))
                right--;
            else if (leftCh != rightCh) {
                isValidPalindrome = false;
                break;
            } else {
                left++;
                right--;
            }
        }
        return isValidPalindrome;
    }
}