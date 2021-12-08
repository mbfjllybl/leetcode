package Java.largestNumber;

import java.util.Arrays;

/**
 * @author mbfjllybl
 * @version 1.0
 * @description: TODO
 * @date 2021/12/8 下午2:33
 */
class Solution {
    public String largestNumber(int[] nums) {
        String[] numbers = new String[nums.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = nums[i] + "";
        }
        Arrays.sort(numbers, (a, b) -> -(a + b).compareTo(b + a));
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            res.append(numbers[i]);
        }
        String ans = res.toString();
        if (ans.length() != 0 && ans.charAt(0) == '0') return "0";
        else return ans;
    }
}
