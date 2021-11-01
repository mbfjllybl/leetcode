package Java.stringToIntegerAtoi;

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        int sgn = 1;
        int begin = 0;
        if (s.charAt(0) == '+') {
            sgn = 1;
            begin++;
        } else if (s.charAt(0) == '-') {
            sgn = -1;
            begin++;
        }

        long res = 0;

        for (int i = begin; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) break;
            res = res * 10 + Integer.parseInt(s.charAt(i) + "");
            if (res * sgn < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (res * sgn > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }

        return (int)res * sgn;
    }
}