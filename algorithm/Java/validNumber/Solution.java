package Java.validNumber;

/**
 * @author mbfjllybl
 * @version 1.0
 * @description: TODO
 * @date 2021/11/20 上午9:01
 */
class Solution {
    public boolean isNumber(String s) {
        int flagE = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = s.substring(1);
        }

        int hasDigit = 0, hasD = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                hasDigit = 1;
            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                // System.out.println(i + " " + s.length());
                if(i + 1 == s.length()) return false;
                if (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-') {
                    if (i + 2 == s.length()) return false;
                    i++;
                }
                if (flagE == 1) return false;
                if (hasDigit == 0) return false;
                flagE = 1;
            } else if (s.charAt(i) == '.') {
                if (flagE == 1) return false;
                if (i + 1 == s.length() && hasDigit == 0) return false;
                if (hasD == 1) return false;
                hasD = 1;
            } else if (Character.isAlphabetic(s.charAt(i))) {
                return false;
            } else {
                return false;
            }

        }
        return true;
    }
}
