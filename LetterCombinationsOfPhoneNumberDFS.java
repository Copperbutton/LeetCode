public class Solution {
    private static String[] keyboard = { " ", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        findLetterCombinations(digits, 0, result, new char[digits.length()]);
        return result;
    }

    private void findLetterCombinations(String digits, int start,
            List<String> result, char[] path) {
        if (start == digits.length()) {
            result.add(new String(path));
            return;
        }

        int digit = digits.charAt(start) - '0';
        String key = keyboard[digit];
        char tmp = path[start];
        if (digit == 1)
            findLetterCombinations(digits, start + 1, result, path);

        for (int i = 0; i < key.length(); i++) {
            path[start] = key.charAt(i);
            findLetterCombinations(digits, start + 1, result, path);
        }
        path[start] = tmp;
    }
}