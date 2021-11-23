package Java.textJustification;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int last = 0, cnt = 0;
        for (int i = 0; i < words.length; i++) {
            if (cnt + words[i].length() <= maxWidth) {
                cnt += words[i].length();
                if (cnt == maxWidth) {
                    String tmp = "";
                    for (int j = last; j <= i; j++) tmp += words[j] + " ";
                    res.add(tmp.substring(0, tmp.length() - 1));
                    cnt = 0;
                    last = i + 1;
                } else {
                    cnt++;
                }
            } else {
                int count = (i - 1) - last + 1;
                if (count == 1) {
                    String tmp = "";
                    tmp += words[i - 1];
                    while (tmp.length() < maxWidth) tmp += " ";
                    res.add(tmp);
                    last = i;
                    i--;
                    cnt = 0;
                    continue;
                }
                int space = (maxWidth - cnt + count) / (count - 1);
                int yu = (maxWidth - cnt + count) % (count - 1);
                String tmp = "";
                for (int j = last; j < last + yu; j++) {
                    tmp += words[j];
                    for (int k = 0; k < 1 + space; k++) tmp += " ";
                }
                for (int j = last + yu; j <= i - 2; j++) {
                    tmp += words[j];
                    for (int k = 0; k < space; k++) tmp += " ";
                }
                tmp += words[i - 1];
                res.add(tmp);
                last = i;
                cnt = 0;
                i--;
            }
        }
        if (cnt != 0) {
            String tmp = "";
            for (int i = last; i < words.length; i++) {
                tmp += words[i] + " ";
            }
            tmp = tmp.substring(0, tmp.length() - 1);
            while (tmp.length() < maxWidth) tmp += " ";
            res.add(tmp);
        }
        return res;
    }
}


