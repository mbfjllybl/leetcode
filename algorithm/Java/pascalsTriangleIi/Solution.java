package Java.pascalsTriangleIi;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> last = new ArrayList<>();

        last.add(1);
        if (rowIndex == 0) return last;
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> now = new ArrayList<>();
            now.add(1);
            for (int j = 1; j < last.size(); j++) {
                now.add(last.get(j - 1) + last.get(j));
            }
            now.add(1);
            last = now;
        }
        return last;
    }
}