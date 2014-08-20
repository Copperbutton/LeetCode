/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 *
 *
 *
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
 * "ce", "cf"].
 **/
public class LetterCombinationsOfPhoneNumberRecrusive {
    public List<String> letterCombinations(String digits) {
        String[] keyboard = { " ", "", "abc", "def", "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz" };
        List<String> result = new ArrayList<String>();
        findLetterCombinations(digits, keyboard, result, new StringBuilder(), 0);
        return result;
    }
    
    private void findLetterCombinations(String digits, String[] keyboard,
                                        List<String> result, StringBuilder path, int depth) {
        if (depth == digits.length()) {
            result.add(path.toString());
            return;
        }
        
        int digit = digits.charAt(depth) - '0';
        String key = keyboard[digit];
        for (char ch : key.toCharArray()) {
            path.append(ch);
            findLetterCombinations(digits, keyboard, result, path, depth + 1);
            path.setLength(path.length() - 1);
        }
    }
}
