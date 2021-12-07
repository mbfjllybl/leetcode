package Java.rotateArray;

class Solution {
    public void rotate(int[] nums, int k) {
        for (int i = 0, j = nums.length - k; i < k; i++) {
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
