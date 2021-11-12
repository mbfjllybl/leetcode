package Java.divideTwoIntegers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int divide(int x, int y) {
        // x/y
        int abs = (x < 0 && y > 0 || x > 0 && y < 0) ? -1 : 1;
        x = -Math.abs(x);
        y = -Math.abs(y);
        List<Integer> list = new ArrayList<>();
        for (int i = y; i >= x; i += i) {
            list.add(i);
            if (i < x - i) break;
        }
        System.out.println(list.toString());
        int ans = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) >= x) {
                ans -= 1 << i;
                x -= list.get(i);
            }
        }
        if (abs == -1) return ans;
        else {
            if (ans == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            else return -ans;
        }
    }
}
