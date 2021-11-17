package Java.jumpGame;

class Solution {
    public boolean canJump(int[] nums) {
        int mx = nums[0];
        int mxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            mx = Math.max(mx, i + nums[i]);
            if (mx == i && mx == mxPos) {
                return false;
            } else if (mx == i){
                mx = mxPos;

            }


        }
        return true;
    }
}