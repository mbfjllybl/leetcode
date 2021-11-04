package Java.threeSumClosest_3sumClosest;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0, mn = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    if (Math.abs(sum - target) < mn) {
                        mn = Math.abs(sum - target);
                        ans = sum;
                    }
                    r--;
                } else {
                    if (Math.abs(sum - target) < mn) {
                        mn = Math.abs(sum - target);
                        ans = sum;
                    }
                    l++;
                }
            }
        }
        return ans;
    }
}