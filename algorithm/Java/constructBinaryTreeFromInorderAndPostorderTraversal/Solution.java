package Java.constructBinaryTreeFromInorderAndPostorderTraversal;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return buildTreeSolution(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeSolution(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
        if (l2 > r2) return null;
        TreeNode node = new TreeNode(postorder[r2]);
        int index = hashMap.get(node.val);
        int len = index - l1;
        node.left = buildTreeSolution(inorder, l1, index - 1, postorder, l2, l2 + len - 1);
        node.right = buildTreeSolution(inorder, index + 1, r1, postorder, l2 + len, r2 - 1);
        return node;
    }
}
