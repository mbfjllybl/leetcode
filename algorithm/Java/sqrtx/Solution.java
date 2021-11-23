package Java.sqrtx;

class Solution {
    public int mySqrt(int x) {
        double l = 0, r = x;
        while (r - l >= 1e-7) {
            double mid = (l + r) / 2;
            if (mid * mid <= x) l = mid;
            else r = mid;
        }
        return (int) (l + 0.00001);
    }
}