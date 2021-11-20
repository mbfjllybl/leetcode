package Java.plusOne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author mbfjllybl
 * @version 1.0
 * @description: TODO
 * @date 2021/11/20 上午9:18
 */
class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length -1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
                continue;
            }
        }
        int[] p = new int[digits.length+1];
        p[0] = 1;
        return p;

    }
}
