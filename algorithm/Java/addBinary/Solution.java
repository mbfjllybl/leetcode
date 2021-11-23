package Java.addBinary;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String addBinary(String a, String b) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int i = a.length() - 1; i >= 0; i--) listA.add(Integer.parseInt(a.charAt(i) + ""));
        for (int i = b.length() - 1; i >= 0; i--) listB.add(Integer.parseInt(b.charAt(i) + ""));
        List<Integer> ans = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < listA.size() || i < listB.size() || t != 0; i++) {
            if (i < listA.size()) t += listA.get(i);
            if (i < listB.size()) t += listB.get(i);
            ans.add(t % 2);
            t /= 2;
        }
        String res = "";
        for (int i = ans.size() - 1; i >= 0; i--) {
            res += ans.get(i) + "";
        }
        return res;
    }
}