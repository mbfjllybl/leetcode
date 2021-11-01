package Java.palindromeNumber;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = x;
        int res = 0;
        while (y != 0) {
            res *= 10;
            res += y % 10;
            y /= 10;
        }
        return res == x;
    }
}
