package Java.longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            while (hashMap.containsKey(s.charAt(i))) {
                hashMap.remove(s.charAt(j));
                j++;
            }
            hashMap.put(s.charAt(i), 1);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}