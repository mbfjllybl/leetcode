package Java.jumpGameIi;

class Solution {
    public int jump(int[] nums) {
        int mx = nums[0], mxPos = 0;
        int step = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i > mx) {
                step++;
                mx = mxPos;

            }
            mxPos = Math.max(mxPos, i + nums[i]);
            if (i == nums.length - 1) return step + 1;
        }
        return step;
    }
}