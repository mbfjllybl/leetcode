package Java.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        boolean[][] f = new boolean[matrix.length][matrix[0].length];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0, j = 0, k = 0; ;) {
            if (f[i][j] == false) list.add(matrix[i][j]);
            f[i][j] = true;
            if (list.size() == matrix.length * matrix[0].length) break;
            int x = dx[k] + i, y = dy[k] + j;
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || f[x][y] == true) {
                k++;
                k %= 4;
                continue;
            }
            i = x;
            j = y;
        }
        return list;
    }
}