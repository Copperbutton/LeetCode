/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */

public class GenerateParenthesesDFS {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generateParenthesis(n, n, result, new LinkedList<String>());
        return result;
    }

    private void generateParenthesis(int remainLeftParen, int remainRightParen,
            List<String> result, LinkedList<String> path) {
        if (remainLeftParen == 0 && remainRightParen == 0) {
            StringBuilder builder = new StringBuilder();
            for (String paren : path)
                builder.append(paren);
            result.add(builder.toString());
            return;
        }

        if (remainLeftParen > 0) {
            path.add("(");
            generateParenthesis(remainLeftParen - 1, remainRightParen, result,
                    path);
            path.removeLast();
        }

        if (remainRightParen > 0 && remainLeftParen < remainRightParen) {
            path.add(")");
            generateParenthesis(remainLeftParen, remainRightParen - 1, result,
                    path);
            path.removeLast();
        }
    }
}