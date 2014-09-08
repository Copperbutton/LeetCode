/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 */

public class ReverseWordsInAStringWithoutSplit {
    public String reverseWords(String s) {
        char[] chs = s.toCharArray();

        Stack<String> stack = new Stack<String>();
        boolean leadingZeros = true;
        for (int i = 0; i < chs.length;) {
            if (chs[i] != ' ') {
                StringBuilder builder = new StringBuilder();
                while (i < chs.length && chs[i] != ' ')
                    builder.append(chs[i++]);
                stack.push(builder.toString());
                leadingZeros = false;
            } else {
                while (i < chs.length && chs[i] == ' ')
                    i++;
                if (i < chs.length && !leadingZeros)
                    stack.push(" ");
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty())
            result.append(stack.pop());
        return result.toString();
    }
}