package Java.sortColors;

class Solution {
    public void sortColors(int[] nums) {
        for (int i = 0, l = 0, r = nums.length - 1; i <= r; i++) {
            while (nums[i] == 0 || nums[i] == 2) {
                if (nums[i] == 0) {
                    if (i == l) {
                        l++;
                        break;
                    }
                    swap(nums, i, l);
                    l++;
                } else if (nums[i] == 2) {
                    if (i == r) {
                        r--;
                        break;
                    }
                    swap(nums, i, r);
                    r--;
                }
            }
        }
    }

    private void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}

