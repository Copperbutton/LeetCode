/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13",
 * "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int result = -1;
        Stack<String> stack = new Stack<String>();
        for (String token : tokens) {
            if (isOperator(token)) {
                if (stack.size() < 2)
                    break;
                String right = stack.pop();
                String left = stack.pop();
                String res = caculate(left, right, token);
                stack.push(res);
            } else {
                stack.push(token);
            }
        }
        if (stack.size() == 1)
            result = Integer.parseInt(stack.peek());
        return result;
    }

    private boolean isOperator(String token) {
        return (token.equals("+") || token.equals("-") || token.equals("*") || token
                .equals("/"));
    }

    private String caculate(String left, String right, String operator) {
        int leftNum = Integer.parseInt(left);
        int rightNum = Integer.parseInt(right);
        int result = 0;
        if (operator.equals("+")) {
            result = leftNum + rightNum;
        } else if (operator.equals("-")) {
            result = leftNum - rightNum;
        } else if (operator.equals("*")) {
            result = leftNum * rightNum;
        } else if (operator.equals("/")) {
            if (rightNum != 0)
                result = leftNum / rightNum;
        }
        return String.valueOf(result);
    }
}