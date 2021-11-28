package Java.restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(0, 0, s, "");
        return res;
    }

    private void dfs(int u, int cnt, String s, String path) {
        if (u >= s.length()) return;
        if (cnt == 3) {
            if (s.charAt(u) == '0' && s.length() - 1 - u + 1 >= 2) return;
            int leave = Integer.parseInt(s.substring(u, s.length()));
            if (leave > 255) return;
            else {
                path += leave;
                res.add(path);
                return;
            }
        }

        if (s.charAt(u) == '0') {
            dfs(u + 1, cnt + 1, s, path + "0.");
        } else {
            int count = 0;
            for (int i = u; i < s.length(); i++) {
                int x = Integer.parseInt(s.charAt(i) + "");
                count *= 10;
                count += x;
                path += x;
                if (count <= 255) {
                    dfs(i + 1, cnt + 1, s, path + ".");
                } else {
                    break;
                }
            }
        }
    }


}
