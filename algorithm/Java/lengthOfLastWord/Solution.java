package Java.lengthOfLastWord;

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isAlphabetic(s.charAt(i))) {
                ans++;
            } else break;
        }
        return ans;
    }
}
