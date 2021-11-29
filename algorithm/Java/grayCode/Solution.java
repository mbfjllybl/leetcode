package Java.grayCode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        while (n-- > 0) {
            for (int i = list.size() - 1; i >= 0; i--) {
                list.set(i, list.get(i) * 2);
                list.add(list.get(i) + 1);
            }
        }
        return list;
    }
}