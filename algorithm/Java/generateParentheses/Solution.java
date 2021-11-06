package Java.generateParentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();

    public void dfs(int i, int j, int n, String path) {
        if (i + j == n + n) {
            res.add(path);
            return;
        }
        if (i < n) dfs(i + 1, j, n, path + "(");
        if (j < i) dfs(i, j + 1, n, path + ")");
    }

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n, "");
        return res;
    }
}
