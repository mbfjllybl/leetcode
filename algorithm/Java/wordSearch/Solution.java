package Java.wordSearch;

import java.util.Arrays;

class Solution {
    boolean[][] st;
    boolean flag;

    public boolean exist(char[][] board, String word) {
        st = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                for (int k = 0; k < st.length; k++) Arrays.fill(st[k], false);
                dfs(board, i, j, "", word);
                if (flag) return true;
            }
        return false;
    }

    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};

    void dfs(char[][] board, int x, int y, String path, String word) {
        st[x][y] = true;
        path += board[x][y];
        if (path.length() > word.length()) return;
        if (path.charAt(path.length() - 1) != word.charAt(path.length() - 1)) return;
        if (word.equals(path)) flag = true;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a < 0 || a >= board.length || b < 0 || b >= board[0].length) continue;
            if (st[a][b]) continue;
            dfs(board, a, b, path, word);
            st[a][b] = false;
        }
    }
}
