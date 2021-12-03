package Java.bitwiseAndOfNumbersRange;

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            if (left >> i != right >> i) break;
            if ((left >> i & 1) == 1) res += 1 << i;
        }
        return res;
    }
}