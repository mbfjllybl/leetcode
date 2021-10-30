package Java.longestPalindromicSubstring;

class Solution {
    public String longestPalindrome(String s) {
        int maxn = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (l != r - 1 && r - l + 1 - 2 > maxn) {
                res = s.substring(l + 1, r);
                maxn = r - l + 1 - 2;
            }
            l = r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (r - l + 1 - 2 > maxn) {
                res = s.substring(l + 1, r);
                maxn = r - l + 1 - 2;
            }
        }
        return res;
    }
}