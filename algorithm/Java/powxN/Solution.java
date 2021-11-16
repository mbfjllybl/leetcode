package Java.powxN;

class Solution {
    public double myPow(double x, int n) {
        if (n > 0) return ksm(x, n);
        else return 1 / ksm(x, -(long)n);
    }

    private double ksm(double x, long n) {
        double res = 1;
        while (n != 0) {
            if ((n & 1) == 1) res *= x;
            x *= x;
            n >>= 1;
        }
        return res;
    }
}



