package Java.validParentheses;

import java.util.LinkedList;

class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t == '(' || t == '[' || t == '{') {
                stack.addLast(t);
            } else {
                System.out.println(stack.getLast());
                System.out.println(t);
                if (!stack.isEmpty() && Math.abs(stack.getLast() - t) <= 2) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}