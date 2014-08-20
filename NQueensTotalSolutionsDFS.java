/**
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 **/

public class NQueeenTotalSolutionsDFS {
    private static final boolean available = true;
    private static final boolean unavailable = false;
    private int NORM;
    private boolean[] column;
    private boolean[] leftDiag;
    private boolean[] rightDiag;
    private int totalSolutions;

    public int totalNQueens(int n) {
        NORM = n - 1;
        column = new boolean[n];
        leftDiag = new boolean[2 * n - 1];
        rightDiag = new boolean[2 * n - 1];
        totalSolutions = 0;

        for (int col = 0; col < n; col++)
            column[col] = available;

        for (int i = 0; i < 2 * n - 1; i++) {
            leftDiag[i] = available;
            rightDiag[i] = available;
        }

        findTotalSolutions(n, 0);
        return totalSolutions;
    }

    private void findTotalSolutions(int N, int row) {
        for (int col = 0; col < N; col++) {
            if (column[col] == available && leftDiag[row + col] == available
                    && rightDiag[row - col + NORM] == available) {
                column[col] = unavailable;
                leftDiag[row + col] = unavailable;
                rightDiag[row - col + NORM] = unavailable;

                if (row < N - 1)
                    findTotalSolutions(N, row + 1);
                else
                    totalSolutions++;

                column[col] = available;
                leftDiag[row + col] = available;
                rightDiag[row - col + NORM] = available;
            }
        }
    }
}