/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 */

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] tokens = s.trim().split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (int i = tokens.length - 1; i >= 0; i--) {
            builder.append(tokens[i]);
            builder.append(" ");
        }
        if (builder.length() > 0)
            builder.setLength(builder.length() - 1);
        return builder.toString();
    }
}