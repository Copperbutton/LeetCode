/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 */

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char[] chs = s.toCharArray();
        int length = 0, index = chs.length - 1;
        while (index >= 0 && chs[index] == ' ')
            index--;

        while (index >= 0 && chs[index] != ' ') {
            index--;
            length++;
        }

        return length;
    }
}