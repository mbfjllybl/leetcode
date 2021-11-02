package Java.regularExpressionMatching;

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] f = new boolean[40][40];
        int n = s.length(), m = p.length();
        s = " " + s;
        p = " " + p;

        f[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j + 1 <= m && p.charAt(j + 1) == '*') continue;
                if (p.charAt(j) != '*') {
                    if (i >= 1 && j >= 1)
                        f[i][j] = f[i - 1][j - 1] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                } else {
                    // f[i][j] = f[i][j - 2] f[i - 1][j - 2] i==j-1 f[i - 2][j - 2] i-1==j-1&&i==j-1 f[i - 3][j - 2]
                    // f[i - 1][j] = f[i - 1][j - 2] f[i - 2][j - 2] i-1==j-1
                    f[i][j] = (j - 2 >= 0 && f[i][j - 2]) || (i - 1 >= 0 && f[i - 1][j] && (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.'));
                }
            }
        }
        return f[n][m];
    }
}
