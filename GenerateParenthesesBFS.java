/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParenthesesBFS {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String> ();
        
        Queue<String> pathQueue = new LinkedList<String>();
        Queue<Integer> leftParenNumQueue = new LinkedList<Integer>();
        Queue<Integer> rightParenNumQueue = new LinkedList<Integer>();
        
        pathQueue.offer("");
        leftParenNumQueue.offer(0);
        rightParenNumQueue.offer(0);
        while (!pathQueue.isEmpty()) {
            String currParen = pathQueue.poll();
            int leftParenNum = leftParenNumQueue.poll();
            int rightParenNum = rightParenNumQueue.poll();
            
            if (leftParenNum == n && rightParenNum == n) {
                result.add(currParen);
                continue;
            }
            
            if (leftParenNum < n ) {
                pathQueue.offer(currParen + "(");
                leftParenNumQueue.offer(leftParenNum + 1);
                rightParenNumQueue.offer(rightParenNum);
            }
            
            if (rightParenNum < n && rightParenNum < leftParenNum) {
                pathQueue.offer(currParen + ")");
                leftParenNumQueue.offer(leftParenNum);
                rightParenNumQueue.offer(rightParenNum + 1);
            }
        }
        return result;
    }
}