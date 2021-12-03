package Java.pathSumIi;

import java.util.ArrayList;
import java.util.List;

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
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        dfs(root, 0, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int sum, int targetSum) {
        path.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                res.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }

        if (root.left != null) {
            dfs(root.left, sum, targetSum);
        }
        if (root.right != null) {
            dfs(root.right, sum, targetSum);
        }

        path.remove(path.size() - 1);
    }
}