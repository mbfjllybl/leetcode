package Java.setMatrixZeroes;

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row1 = false, col1 = false, row2 = false, col2 = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) col1 = true;
            if (matrix[i][matrix[0].length - 1] == 0) col2 = true;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) row1 = true;
            if (matrix[matrix.length - 1][i] == 0) row2 = true;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (col1) for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
        if (row1) for (int i = 0; i < matrix[0].length; i++) matrix[0][i] = 0;
        if (col2) for (int i = 0; i < matrix.length; i++) matrix[i][matrix[0].length - 1] = 0;
        if (row2) for (int i = 0; i < matrix[0].length; i++) matrix[matrix.length - 1][i] = 0;
    }
}


