package Java.letterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public Map<Character, String> phoneMap = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public List<String> res = new ArrayList<>();

    public void dfs(int u, String digits, StringBuilder path) {
        if (u == digits.length()) {
            if (!path.equals("")) res.add(path.toString());
            return;
        }

        String s =  phoneMap.get(digits.charAt(u));
        for (int i = 0; i < s.length(); i++) {
            dfs(u + 1, digits, path.append(s.charAt(i)));
            path.deleteCharAt(path.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        dfs(0, digits, new StringBuilder());
        return res;
    }
}