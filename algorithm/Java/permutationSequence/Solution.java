package Java.permutationSequence;

class Solution {
    public String getPermutation(int n, int k) {
        String s = "";
        int cnt = 1;
        for (int i = 1; i <= n - 1; i++) cnt *= i;
        boolean[] f = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == n) {
                for (int j = 1; j <= n; j++) if (f[j] == false) {
                    s += j;
                    break;
                }
                break;
            }
            int tmp = (k + cnt - 1)/ cnt;
            k = k - (tmp - 1) * cnt;
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (f[j] == false) {
                    count++;
                }
                if (count == tmp) {
                    s += j;
                    f[j] = true;
                    break;
                }
            }
            if (n != i) cnt /= n - i;
        }
        return s;
    }
}