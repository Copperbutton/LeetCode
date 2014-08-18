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
public class LetterCombinationsOfPhoneNumberInteative {
    public List<String> letterCombinations(String digits) {
        String[] keyboard = { " ", "", "abc", "def", "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz" };
        List<String> result = new ArrayList<String>();
        
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            String key = keyboard[digit];
            int resultSize = result.size();
            for (int j = 0; j < resultSize; j++) {
                String oldString = result.get(j);
                for (char ch : key.toCharArray()) {
                    result.add(oldString + ch);
                }
            }
            result = result.subList(resultSize, result.size());
        }
        return result;
    }
}
