/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 */

public class ValidParenthese {
    public boolean isValid(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('(', 1);
        map.put(')', -1);
        map.put('[', 2);
        map.put(']', -2);
        map.put('{', 3);
        map.put('}', -3);
        Stack<Character> stack = new Stack<Character>();
        char[] chs = s.toCharArray();
        boolean validParenthese = true;
        for (char ch : chs) {
            int value = map.get(ch);
            if (value > 0) {
                stack.push(ch);
            } else if (stack.isEmpty() || value + map.get(stack.pop()) != 0) {
                validParenthese = false;
                break;
            }
        }
        if (!stack.isEmpty())
            validParenthese = false;
        return validParenthese;
    }
}