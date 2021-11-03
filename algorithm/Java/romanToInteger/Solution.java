package Java.romanToInteger;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && symbolValues.get(s.charAt(i)) < symbolValues.get(s.charAt(i + 1)))
                res -= symbolValues.get(s.charAt(i));
            else res += symbolValues.get(s.charAt(i));
        }
        return res;
    }
}