package Java.removeDuplicatesFromSortedArrayIi;

class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (j == 0 || j == 1) {
                nums[j] = nums[i];
                j++;
            } else {
                if (nums[i] != nums[j - 2]) nums[j++] = nums[i];
            }
        }
        return j;
    }
}