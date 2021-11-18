package Java.spiralMatrixIi;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        boolean[][] f = new boolean[n][n];
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        for (int i = 0, j = 0, cnt = 0, k = 0; cnt < n * n; cnt++) {
            if (f[i][j] == false) res[i][j] = cnt + 1;
            f[i][j] = true;
            int x = i + dx[k], y = j + dy[k];
            if (x < 0 || x >= n || y < 0 || y >= n || f[x][y]) {
                k++;
                k %= 4;
                if (cnt == n * n - 1) break;
                cnt--;
                continue;
            } else {
                i = x;
                j = y;
            }
        }
        return res;
    }
}

