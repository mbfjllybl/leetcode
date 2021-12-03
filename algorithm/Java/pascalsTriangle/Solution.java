package Java.pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(1);
        ans.add(new ArrayList<>(path));
        for (int i = 2; i <= numRows; i++) {
            path.clear();
            path.add(1);
            List<Integer> last = ans.get(ans.size() - 1);
            for (int j = 1; j < last.size(); j++) {
                path.add(last.get(j - 1) + last.get(j));
            }
            path.add(1);
            ans.add(new ArrayList<>(path));
        }
        return ans;
    }
}