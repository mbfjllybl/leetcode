package Java.numberOfIslands;

class Solution {
    boolean[][] st;
    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        st = new boolean[n][m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (st[i][j] == false && grid[i][j] == '1') {
                    res++;
                    st[i][j] = true;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int a, int b) {
        for (int k = 0; k < 4; k++) {
            int x = a + dx[k], y = b + dy[k];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) continue;
            if (grid[x][y] == '0') continue;
            if (st[x][y]) continue;
            st[x][y] = true;
            dfs(grid, x, y);
        }
    }
}