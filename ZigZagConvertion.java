/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P A H N A P L S I I G Y I R And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should
 * return "PAHNAPLSIIGYIR".
 */

public class ZigZagConvertion {
    public String convert(String s, int nRows) {
        if (nRows == 1)
            return s;

        List<List<Character>> matrix = new ArrayList<List<Character>>();
        char[] sArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int index = i % (nRows + nRows - 2);
            if (index < nRows) {
                if (index == matrix.size())
                    matrix.add(new ArrayList<Character>());
            } else {
                int newIndex = index - nRows;
                index = nRows - 2 - newIndex;
            }
            List<Character> row = matrix.get(index);
            row.add(sArray[i]);
        }

        StringBuilder builder = new StringBuilder();
        for (List<Character> list : matrix) {
            for (Character ch : list)
                builder.append(ch);
        }
        return builder.toString();
    }
}