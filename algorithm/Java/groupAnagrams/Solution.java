package Java.groupAnagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            map.computeIfAbsent(String.valueOf(tmp), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
