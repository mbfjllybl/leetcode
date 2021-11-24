package Java.minimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        String res = "";
        for (int i = 0, j = 0, cnt = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
            if (mapT.containsKey(s.charAt(i)) && mapS.get(s.charAt(i)) <= mapT.get(s.charAt(i))) cnt++;
            while (j < i && (!mapT.containsKey(s.charAt(j)) || mapS.get(s.charAt(j)) > mapT.get(s.charAt(j)))) {
                mapS.put(s.charAt(j), mapS.get(s.charAt(j)) - 1);
                j++;
            }
            if (cnt == t.length() && (i - j + 1 < res.length() || res.length() == 0)) {
                res = s.substring(j, i + 1);
            }
        }
        return res;
    }
}