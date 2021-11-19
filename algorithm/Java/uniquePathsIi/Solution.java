package Java.uniquePathsIi;

/**
 * @author mbfjllybl
 * @version 1.0
 * @description: TODO
 * @date 2021/11/19 上午10:06
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] f = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        f[1][1] = 1;
        for (int i = 1; i <= obstacleGrid.length; i++) {
            for (int j = 1; j <= obstacleGrid[0].length; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    f[i][j] = 0;
                } else {
                    if (i - 2 >= 0 && obstacleGrid[i - 1 - 1][j - 1] != 1) f[i][j] += f[i - 1][j];
                    if (j - 2 >= 0 && obstacleGrid[i - 1][j - 1 - 1] != 1) f[i][j] += f[i][j - 1];
                }
            }
        }
        return f[obstacleGrid.length][obstacleGrid[0].length];
    }
}


