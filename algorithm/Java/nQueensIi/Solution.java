package Java.nQueensIi;


import java.util.ArrayList;
import java.util.List;

class Solution {
    int ans;
    List<String> path = new ArrayList<>();
    boolean[] cols, diagonal, diagonal_;

    public int totalNQueens(int n) {
        diagonal = new boolean[n * 2 - 1];
        diagonal_ = new boolean[n * 2 - 1];
        cols = new boolean[n];
        dfs(0, n);
        return ans;
    }

    private void dfs(int u, int n) {
        if (u == n) {
            ans++;
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append('.');

        for (int i = 0; i < n; i++) {
            if (cols[i] == false && diagonal[n - 1 - (u - i)] == false && diagonal_[u + i] == false) {
                cols[i] = true;
                diagonal[n - 1 - (u - i)] = true;
                diagonal_[u + i] = true;
                sb.replace(i, i + 1, "Q");
                path.add(sb.toString());
                dfs(u + 1, n);
                path.remove(path.size() - 1);
                cols[i] = false;
                diagonal[n - 1 - (u - i)] = false;
                diagonal_[u + i] = false;
                sb.replace(i, i + 1, ".");
            }
        }
    }
}