package Java.zigzagConversion;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int n = (numRows - 1) * 2;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int l = i; l < s.length(); l += n) stringBuilder.append(s.charAt(l));
            } else {
                for (int l = i, r = n - i; l < s.length() || r < s.length(); l += n, r += n) {
                    if (l < s.length()) stringBuilder.append(s.charAt(l));
                    if (r < s.length()) stringBuilder.append(s.charAt(r));
                }
            }
        }
        return stringBuilder.toString();
    }
}