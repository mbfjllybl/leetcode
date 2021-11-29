package Java.maximalRectangle;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                add(sum, i + 1, j + 1, matrix[i][j]);
            }
        int res = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                for (int p = 1; p <= i; p++)
                    for (int q = 1; q <= j; q++) {
                        int count = (Math.abs(i - p) + 1) * (Math.abs(j - q) + 1);
                        if (count == get(sum, p, q, i, j)) {
                            res = Math.max(res, count);
                        }
                    }
        return res;
    }

    private void add(int[][] sum, int i, int j, char matrix) {
        int x = 0;
        if (matrix == '0') x = 0;
        else x = 1;
        sum[i][j] = x + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
    }

    private int get(int[][] sum, int x1, int y1, int x2, int y2) {
        return sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1];
    }
}
