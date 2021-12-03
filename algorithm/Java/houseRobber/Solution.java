package Java.houseRobber;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = Math.max(f[i - 1], f[Math.max(0, i - 2)] + nums[i - 1]);
        }
        return f[n];
    }
}