package Java.minimumPathSum;


import java.util.Arrays;

/**
 * @author mbfjllybl
 * @version 1.0
 * @description: TODO
 * @date 2021/11/20 上午8:51
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(f[i], 0x3f3f3f3f);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) f[i][j] = grid[0][0];
                else f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return f[n][m];
    }
}