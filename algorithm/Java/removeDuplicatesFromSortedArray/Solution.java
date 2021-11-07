package Java.removeDuplicatesFromSortedArray;

class Solution {
    public int removeDuplicates(int[] nums) {
        int k = -1;
        for (int i = 0; i < nums.length; i++) {
            if (k == -1) nums[++k] = nums[i];
            else if (nums[i] != nums[k]) nums[++k] = nums[i];
        }
        return k + 1;
    }
}