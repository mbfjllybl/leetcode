package Java.multiplyStrings;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String multiply(String num1, String num2) {
        List<Integer> n1 = new ArrayList<>();
        List<Integer> n2 = new ArrayList<>();
        for (int i = num1.length() - 1; i >= 0; i--) n1.add(Integer.parseInt(num1.charAt(i) + ""));
        for (int i = num2.length() - 1; i >= 0; i--) n2.add(Integer.parseInt(num2.charAt(i) + ""));
        int[] res = new int[n1.size() + n2.size() + 1];
        for (int i = 0; i < n1.size(); i++) {
            for (int j = 0; j < n2.size(); j++) {
                int tmp = n1.get(i) * n2.get(j);
                res[i + j] += tmp;

            }
        }

        int t = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            t += res[i];
            sb.append(t % 10);
            t /= 10;
        }

        String tmp = sb.reverse().toString();
        int i = 0;
        while (i < tmp.length() - 1 && tmp.charAt(i) == '0') i++;
        return tmp.substring(i);
    }
}