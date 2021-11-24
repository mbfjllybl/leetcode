package Java.subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    void dfs(int u, int[] nums) {
        if (u == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[u]);
        dfs(u + 1, nums);
        list.remove(list.size() - 1);
        dfs(u + 1, nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }
}
