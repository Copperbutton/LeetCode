/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * For example, words: ["This", "is", "an", "example", "of", "text",
 * "justification."] L: 16.
 * 
 * Return the formatted lines as: [ "This    is    an", "example  of text",
 * "justification.  " ] Note: Each word is guaranteed not to exceed L in length.
 * 
 * click to show corner cases.
 * 
 * Corner Cases: A line other than the last line might contain only one word.
 * What should you do in this case? In this case, that line should be
 * left-justified.
 */

public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        if (words.length == 0)
            return result;

        int lengthInRow = 0;
        List<String> row = new ArrayList<String>();
        List<List<String>> textMatrix = new ArrayList<List<String>>();
        for (String word : words) {
            if (lengthInRow + word.length() > L) {
                textMatrix.add(row);
                row = new ArrayList<String>();
                lengthInRow = 0;
            }
            lengthInRow += word.length();
            lengthInRow += 1;
            row.add(word);
        }
        if (row.size() > 0)
            textMatrix.add(row);

        int index = 0;
        while (index < textMatrix.size() - 1) {
            List<String> currRow = textMatrix.get(index);
            String line;
            if (currRow.size() > 1)
                line = justify(textMatrix.get(index), L);
            else
                line = justifyLast(currRow, L);
            result.add(line);
            index++;
        }
        String lastLine = justifyLast(textMatrix.get(index), L);
        result.add(lastLine);
        return result;
    }

    private String justify(List<String> row, int L) {
        int wordTotalLen = 0;
        for (String word : row)
            wordTotalLen += word.length();
        int averageSpace = (L - wordTotalLen) / (row.size() - 1);
        int extraSpace = (L - wordTotalLen) % (row.size() - 1);

        StringBuilder line = new StringBuilder();
        int index = 0;
        while (index < row.size() - 1) {
            line.append(row.get(index));
            for (int j = 0; j < averageSpace; j++)
                line.append(' ');
            if (index < extraSpace)
                line.append(' ');
            index++;
        }
        line.append(row.get(index));

        return line.toString();
    }

    private String justifyLast(List<String> lastRow, int L) {
        int lineLen = 0;
        StringBuilder lastLine = new StringBuilder();
        for (String word : lastRow) {
            lastLine.append(word);
            lineLen += word.length();
            if (lineLen < L) {
                lastLine.append(' ');
                lineLen += 1;
            }
        }

        for (int i = lineLen; i < L; i++)
            lastLine.append(' ');

        return lastLine.toString();
    }
}