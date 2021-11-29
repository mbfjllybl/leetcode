package Java.subsetsIi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums);
        return res;
    }

    private void dfs(int u, int[] nums) {
        if (u == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        int right = u;
        while (right < nums.length && nums[right] == nums[u]) right++;
        int cnt = right - u;
        for (int i = 1; i <= cnt; i++) {
            path.add(nums[u]);
            dfs(right, nums);
        }
        for (int i = 1; i <= cnt; i++) {
            path.remove(path.size() - 1);
        }
        dfs(right, nums);
    }
}
