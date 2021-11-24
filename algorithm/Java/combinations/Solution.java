package Java.combinations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    void dfs(int cnt, int n, int k) {
        if (cnt == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (list.size() == 0) {
            for (int i = 1; i <= n; i++) {
                list.add(i);
                dfs(cnt + 1, n, k);
                list.remove(list.size() - 1);
            }
        } else {
            for (int i = list.get(list.size() - 1) + 1; i <= n; i++) {
                list.add(i);
                dfs(cnt + 1, n, k);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        dfs(0, n, k);
        return res;
    }
}
