package tasks;

import contracts.TaskContract;

public final class Task1 implements TaskContract.Task1 {
    @Override
    public int[][] createMatrix(int n, int m) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                matrix[i][j] = 0;
            }
            matrix[i][0] = 1;
        }
        return matrix;
    }

    @Override
    public void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
