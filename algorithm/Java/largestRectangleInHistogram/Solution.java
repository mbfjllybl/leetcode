package Java.largestRectangleInHistogram;

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int[] tmp = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stack1.empty() && heights[stack1.peek()] >= heights[i]) stack1.pop();
            if (stack1.empty()) tmp[i] = 0;
            else tmp[i] = stack1.peek() + 1;
            stack1.push(i);
        }
        int res = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack2.empty() && heights[stack2.peek()] >= heights[i]) stack2.pop();
            if (stack2.empty()) {
                res = Math.max(res, heights[i] * (heights.length - 1 - tmp[i] + 1));
            } else {
                res = Math.max(res, heights[i] * (stack2.peek() - 1 - tmp[i] + 1));
            }
            stack2.push(i);
        }
        return res;
    }
}