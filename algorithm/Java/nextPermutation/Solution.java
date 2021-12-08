package Java.nextPermutation;

class Solution {
    private void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }

    public void reverse(int[] nums, int l, int r) {
        while (l < r) swap(nums, l++, r--);
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length - 2;
        while (n >= 0 && nums[n] >= nums[n + 1]) n--;
        if (n == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int l = n + 1, r = nums.length - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (nums[mid] > nums[n]) l = mid;
                else r = mid - 1;
            }
            swap(nums, n, l);
            reverse(nums, n + 1, nums.length - 1);
        }
    }
}

