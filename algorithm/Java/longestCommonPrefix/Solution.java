package Java.longestCommonPrefix;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int res = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) res++;
            else break;
        }
        return strs[0].substring(0, res);
    }
}