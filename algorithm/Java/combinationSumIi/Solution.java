package Java.combinationSumIi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<Integer>());
        return ans;
    }

    private void dfs(int[] candidates, int i, int target, List<Integer> path) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (i == candidates.length) return;
        int k = i + 1;
        int cnt = 1;
        while (k < candidates.length && candidates[k] == candidates[i]) {
            cnt++;
            k++;
        }
        for (int j = 0; j <= cnt && target - j * candidates[i] >= 0; j++) {
            dfs(candidates, k, target - j * candidates[i], path);
            path.add(candidates[i]);
        }
        for (int j = 0; j <= cnt && target - j * candidates[i] >= 0; j++) {
            path.remove(path.size() - 1);
        }
    }
}