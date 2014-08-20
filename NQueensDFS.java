/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * For example, There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [ [".Q..", // Solution 1 "...Q", "Q...", "..Q."],
 * 
 * ["..Q.", // Solution 2 "Q...", "...Q", ".Q.."] ]
 */
public class NQueueDFS {
    private final static String QUEUE = "Q";
    private final static String DOT = ".";
    private final static boolean available = true;
    private final static boolean unavailable = false;
    private int NORM;
    private int[] positionInRow;
    private boolean[] column;
    private boolean[] leftDiag;
    private boolean[] rightDiag;
    private List<String[]> result;

    public List<String[]> solveNQueens(int n) {
        NORM = n - 1;
        positionInRow = new int[n];
        column = new boolean[n];
        leftDiag = new boolean[2 * n - 1];
        rightDiag = new boolean[2 * n - 1];
        result = new ArrayList<String[]>();

        for (int i = 0; i < n; i++) {
            positionInRow[i] = 0;
            column[i] = available;
        }

        for (int i = 0; i < 2 * n - 1; i++) {
            leftDiag[i] = available;
            rightDiag[i] = available;
        }

        putNQueue(n, 0);
        return result;
    }

    private void putNQueue(int N, int row) {
        for (int col = 0; col < N; col++) {
            if (column[col] == available && leftDiag[row + col] == available
                    && rightDiag[row - col + NORM] == available) {
                positionInRow[row] = col;
                column[col] = unavailable;
                leftDiag[row + col] = unavailable;
                rightDiag[row - col + NORM] = unavailable;
                if (row < N - 1)
                    putNQueue(N, row + 1);
                else
                    recordNQueue(N);
                column[col] = available;
                leftDiag[row + col] = available;
                rightDiag[row - col + NORM] = available;
            }
        }
    }

    private void recordNQueue(int N) {
        String[] solution = new String[N];
        for (int row = 0; row < N; row++) {
            StringBuilder builder = new StringBuilder();
            for (int col = 0; col < N; col++) {
                if (col == positionInRow[row])
                    builder.append(QUEUE);
                else
                    builder.append(DOT);
            }
            solution[row] = builder.toString();
        }
        result.add(solution);
    }
}