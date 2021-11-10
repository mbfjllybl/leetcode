package Java.searchInsertPosition;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        if (nums[l] == target) return l;
        else if (nums[l] < target) return l + 1;
        else return 0;
    }
}