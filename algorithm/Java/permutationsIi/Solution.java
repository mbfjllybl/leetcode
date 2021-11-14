package Java.permutationsIi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] f;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        f = new boolean[nums.length];
        dfs(0, nums);
        return ans;
    }

    private void dfs(int x, int[] nums) {
        if (x == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && f[i - 1] == false) {
                continue;
            }
            if (!f[i]) {
                f[i] = true;
                path.add(nums[i]);
                dfs(x + 1, nums);
                path.remove(path.size() - 1);
                f[i] = false;
            }
        }
    }
}

