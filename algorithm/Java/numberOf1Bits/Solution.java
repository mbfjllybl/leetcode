package Java.numberOf1Bits;


public class Solution {
    // you need to treat n as an unsigned value
    private int lowbit(int n) {
        return n & -n;
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n -= lowbit(n);
            res++;
        }
        return res;
    }
}