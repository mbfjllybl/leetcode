package Java.convertSortedArrayToBinarySearchTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(0, nums.length - 1, nums);
    }

    private TreeNode build(int l, int r, int[] nums) {
        if (l > r) return null;
        int mid = l + r >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(l, mid - 1, nums);
        node.right = build(mid + 1, r, nums);
        return node;
    }
}
