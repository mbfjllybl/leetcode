package Java.substringWithConcatenationOfAllWords;

import java.util.*;


class Solution {
    Map<String, Integer> s1 = new HashMap<>();
    Map<String, Integer> map = new HashMap<>();

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) s1.put(words[i], s1.getOrDefault(words[i], 0) + 1);
        int n = words[0].length();
        for (int i = 0; i < n; i++) {
            map.clear();
            int count = 0;
            for (int j = i; j + n - 1 < s.length(); j += n) {
                String tmp = s.substring(j, j + n);
                if (j + n - 1 - i + 1 > words.length * n) {
                    String before = s.substring(j - (n * words.length), j - (n * words.length) + n);
                    map.put(before, map.get(before) - 1);
                    if (map.get(before) < s1.getOrDefault(before, 0)) count--;
                }
                map.put(tmp ,map.getOrDefault(tmp, 0) + 1);
                if (map.get(tmp) <= s1.getOrDefault(tmp, 0)) count++;

                if (count == words.length) {
                    ans.add(j - (words.length - 1) * n);
                }
            }
        }
        return ans;
    }
}