package Java.constructBinaryTreeFromPreorderAndInorderTraversal;

import java.time.Period;
import java.util.HashMap;
import java.util.Map;

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
    Map<Integer, Integer> hashMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return buildTreeSolution(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeSolution(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1) return null;
        TreeNode node = new TreeNode(preorder[l1]);
        int order = hashMap.get(node.val);
        int len = order - l2;
        node.left = buildTreeSolution(preorder, l1 + 1, l1 + len, inorder, l2, order - 1);
        node.right = buildTreeSolution(preorder, l1 + len + 1, r1, inorder, order + 1, r2);
        return node;
    }
}