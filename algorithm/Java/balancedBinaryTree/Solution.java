package Java.balancedBinaryTree;

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
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        judge(root);
        return ans;
    }

    private int judge(TreeNode root) {
        if (root == null) return 0;
        int l = judge(root.left), r = judge(root.right);
        if (Math.abs(l - r) > 1) ans = false;
        return Math.max(l, r) + 1;
    }
}