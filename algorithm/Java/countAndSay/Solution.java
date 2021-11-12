package Java.countAndSay;

class Solution {
    public String countAndSay(int n) {
        String last = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder cur = new StringBuilder();
            for (int j = 0; j < last.length(); j++) {
                char tmp = last.charAt(j);
                int cnt = 1;
                while (j + 1 < last.length() && last.charAt(j + 1) == tmp) {
                    cnt++;
                    j++;
                }
                cur.append(cnt).append(tmp);
            }
            last = cur.toString();
        }
        return last;
    }
}
