package Java.longestValidParentheses;

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) == '(') stack.push(i);
            else {
                if (stack.empty()) {
                    stack.push(i);
                } else if (s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    if (stack.empty()) res = Math.max(res, i - 0 + 1);
                    else res = Math.max(res, i - (stack.peek() + 1) + 1);

                } else stack.push(i);
            }
            // System.out.println(res);
        }
        return res;
    }
}