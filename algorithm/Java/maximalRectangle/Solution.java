package Java.maximalRectangle;

import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] heights = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) heights[i][j] = matrix[i][j] == '1' ? 1 : 0;
                else heights[i][j] = matrix[i][j] == '1' ? 1 + heights[i - 1][j] : 0;
            }
        }
        int res = 0;
        for (int i = 0; i < n ; i++) res = Math.max(res, judge(heights[i]));
        return res;
    }

    private int judge(int[] height) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int n = height.length;
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack1.empty() && height[stack1.peek()] >= height[i]) stack1.pop();
            if (stack1.empty()) tmp[i] = 0;
            else tmp[i] = stack1.peek() + 1;
            stack1.push(i);
        }
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack2.empty() && height[stack2.peek()] >= height[i]) stack2.pop();
            if (stack2.empty()) {
                res = Math.max(res, height[i] * (n - 1 - tmp[i] + 1));
            } else {
                res = Math.max(res, height[i] * (stack2.peek() - 1 - tmp[i] + 1));
            }
            stack2.push(i);
        }
        return res;
    }
}
