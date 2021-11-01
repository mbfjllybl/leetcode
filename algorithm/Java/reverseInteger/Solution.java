package Java.reverseInteger;

class Solution {
    public int reverse(int x) {
        int res = 0;
        int sgn = 1;
        if (x < 0) {
            sgn = -1;
            x = -x;
        }

        while (x != 0) {
            int tmp = x % 10;
            if (sgn == 1 && res > (Integer.MAX_VALUE - tmp) / 10) return 0;
            if (sgn == -1 && res * sgn  < (Integer.MIN_VALUE + tmp) / 10) return 0;
            res = res * 10 + tmp;
            x /= 10;
        }
        return res * sgn;
    }
}