package Java.wildcardMatching;

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        s = " " + s;
        p = " " + p;
        boolean f[][] = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (p.charAt(i) == '*') f[0][i] = true;
            else break;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (Character.isLowerCase(p.charAt(j))) {
                    f[i][j] = f[i - 1][j - 1] && s.charAt(i) == p.charAt(j);
                } else if (p.charAt(j) == '?') {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    //f[i][j] = f[i][j-1] f[i-1][j-1] f[i-2][j-1]
                    //f[i-1][j]=f[i-1][j-1]
                    f[i][j] = f[i - 1][j] || f[i][j - 1];

                }
            }
        }
        return f[n][m];

    }
}