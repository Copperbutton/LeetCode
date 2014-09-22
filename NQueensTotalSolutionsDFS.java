/**
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 **/

public class NQueeenTotalSolutionsDFS {
    private boolean[] rowUsed;
    private boolean[] colUsed;
    private boolean[] leftDiagUsed;
    private boolean[] rightDiagUsed;
    private int NORM;
    public int totalNQueens(int N) {
        rowUsed = new boolean[N];
        colUsed = new boolean[N];
        leftDiagUsed = new boolean[2*N - 1];
        rightDiagUsed = new boolean[2*N - 1];
        NORM = N - 1;
        return findNQueueSolution(N, 0);
    }
    
    private int findNQueueSolution(int N, int row) {
        if (row == N)
            return 1;
        int solNum = 0;
        rowUsed[row] = true;
        for (int col = 0; col < N; col++) {
            if (colUsed[col] || leftDiagUsed[row + col] || rightDiagUsed[row - col + NORM])
                continue;
            rightDiagUsed[row - col + NORM] = true;
            leftDiagUsed[row + col] = true;
            colUsed[col] = true;
            solNum += findNQueueSolution(N, row + 1);
            colUsed[col] = false;
            leftDiagUsed[row + col] = false;
            rightDiagUsed[row - col + NORM] = false;
        }
        rowUsed[row] = false;
        return solNum;
    }
}