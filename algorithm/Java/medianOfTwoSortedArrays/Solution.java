package Java.medianOfTwoSortedArrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        if (size % 2 == 1) {
            return get(nums1, nums2, 0, 0, size / 2 + 1);
        } else {
            return (get(nums1, nums2, 0, 0, size / 2) + get(nums1, nums2, 0, 0, size / 2 + 1)) / 2.0;
        }
    }
    public int get(int[] nums1, int[] nums2, int l1, int l2, int x) {
        if (nums1.length - l1 > nums2.length - l2) {
            return get(nums2, nums1, l2, l1, x);
        }

        if (nums1.length == l1) {
            return nums2[l2 + x - 1];
        }

        if (x == 1) {
            return Math.min(nums1[l1], nums2[l2]);
        }

        int side1 = Math.min(x / 2, nums1.length - l1), side2 = x - side1;

        if (nums1[l1 + side1 - 1] <= nums2[l2 + side2 - 1]) {
            return get(nums1, nums2, l1 + side1, l2, x - side1);
        } else {
            return get(nums1, nums2, l1, l2 + side2, x - side2);
        }
    }
}