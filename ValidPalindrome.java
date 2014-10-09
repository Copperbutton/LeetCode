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
        if (s == null || s.length() < 2)
            return true;
        s = s.toLowerCase();
        for (int begin = 0, end = s.length() - 1; begin < end; begin++, end--) {
            while (begin < end && !isAlphanumeric(s.charAt(begin)))
                begin++;
            while (end > begin && !isAlphanumeric(s.charAt(end)))
                end--;
            if (begin > end || s.charAt(begin) != s.charAt(end))
                return false;
        }
        return true;
    }
    
    private boolean isAlphanumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}