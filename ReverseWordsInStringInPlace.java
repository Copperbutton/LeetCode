/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 */

public class ReverseWordsInStringInPlace {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;
            
        char[] array = s.toCharArray();
        
        /** Reverse entire line, reverse each block then*/
        reverseCharArray(array, 0, array.length - 1);
        int start = 0;
        int end = 0;
        boolean zero = array[0] == ' ';
        for (; end < array.length; end++) {
            if (array[end] == ' ') {
                if (!zero) {
                    reverseCharArray(array, start, end - 1);
                    zero = true;
                    start = end;
                }
            } else {
                if (zero) {
                    zero = false;
                    start = end;
                }
                if (!zero && end == array.length - 1)
                    reverseCharArray(array, start, end);
            }
        }
        
        /** Copy to the front part.*/
        start = 0;
        end = 0;
        zero = array[0] == ' ';
        while (end < array.length) {
            if (array[end] == ' ') {
                zero = true;
                end++;
            } else {
                if (zero) {
                    /** Ignore leading space*/
                    if (start != 0)
                        array[start ++] = ' ';
                    zero = false;
                }
                array[start ++] = array[end++];
            }
        }
        return new String(Arrays.copyOfRange(array, 0, start));
    }
    
    private void reverseCharArray(char[] array, int start, int end) {
        while (start < end) {
            char tmp = array[start];
            array[start++] = array[end];
            array[end--] = tmp;
        }
    }
}