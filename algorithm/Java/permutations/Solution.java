package Java.permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] f;

    public List<List<Integer>> permute(int[] nums) {
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
            if (f[i] == false) {
                f[i] = true;
                path.add(nums[i]);
                dfs(x + 1, nums);
                path.remove(path.size() - 1);
                f[i] = false;
            }
        }
    }
}
