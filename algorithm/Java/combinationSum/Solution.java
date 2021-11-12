package Java.combinationSum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target, new ArrayList<Integer>());
        return ans;
    }

    private void dfs(int[] candidates, int i, int target, List<Integer> path) {
        if (i == candidates.length) return;
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        dfs(candidates, i + 1, target, path);
        if (target >= candidates[i]) {
            path.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }
}

