package Java.uniqueBinarySearchTreesIi;

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
    boolean[] st;
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int l, int r) {
        if (l > r) return new ArrayList<TreeNode>() {
            {
                add(null);
            }
        };

        List<TreeNode> res = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            List<TreeNode> resL = dfs(l, i - 1), resR = dfs(i + 1, r);
            for (TreeNode p : resL) {
                for (TreeNode q : resR) {
                    TreeNode node = new TreeNode(i);
                    node.left = p;
                    node.right = q;
                    res.add(node);
                }
            }
        }
        return res;
    }


}