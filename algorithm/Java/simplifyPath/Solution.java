package Java.simplifyPath;

import java.util.LinkedList;

class Solution {
    public String simplifyPath(String path) {
        String[] strs =  path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() == 0) continue;
            if (strs[i].equals(".")) continue;
            else if (strs[i].equals("..")) {
                if (stack.size() != 0) stack.removeLast();
            } else {
                stack.offer(strs[i]);
            }
        }
        String res = "/";
        for (int i = 0; i < stack.size(); i++) {
            res += stack.get(i);
            res += "/";
        }
        if (res.length() != 1) return res.substring(0, res.length() - 1);
        else return res;
    }
}

// "/a//b////c/d//././/..".."