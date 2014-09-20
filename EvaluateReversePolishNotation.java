/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13",
 * "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        for (String str : tokens) {
            if (str.matches("[-+*/]")) {
                String result = strCaculate(stack.pop(), stack.pop(), str);
                stack.push(result);
            } else {
                stack.push(str);
            }
        }
        return Integer.parseInt(stack.pop());
    }
    
    private String strCaculate(String value1, String value2, String operator) {
        int ret = 0;
        int val1 = Integer.parseInt(value1);
        int val2 = Integer.parseInt(value2);
        switch (operator) {
            case "+":
                ret = val1 + val2;
                break;
            case "-":
                ret = val2 - val1;
                break;
            case "*":
                ret = val1 * val2;
                break;
            case "/":
                if (val1 == 0)
                    throw new IllegalArgumentException();
                ret = val2/val1;
                break;
            default:
                break;
        }
        return String.valueOf(ret);
    }
}
