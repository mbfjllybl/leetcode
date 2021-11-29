package Java.decodeWays;

class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 10];
        dp[0] = 1;
        int n = s.length();
        s = " " + s;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i) == '0') {
                if (i == 1) return 0;
                else {
                    if (s.charAt(i - 1) == '0') return 0;
                    else if ((s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0' <= 26) {
                        dp[i] = dp[i - 2];
                    } else {
                        return 0;
                    }
                }
            } else if (i == 1) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1];
                if ((i == n || s.charAt(i + 1) != '0') && s.charAt(i - 1) != '0' && (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0' <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n];
    }
}