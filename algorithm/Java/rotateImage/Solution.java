package Java.rotateImage;

class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < i; j++)
                swap(matrix, i, j, j, i);

            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[0].length / 2; j++)
                    swap(matrix, i, j, i, matrix[0].length - 1 - i);
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int t = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = t;
    }
}
