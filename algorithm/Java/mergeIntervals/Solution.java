package Java.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int mx = intervals[i][1];
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= mx) {
                mx = Math.max(mx, intervals[j][1]);
                j++;
            }
            ans.add(new int[] {intervals[i][0], mx});
            i = j - 1;
        }
        return ans.toArray(new int[ans.size() - 1][]);
    }
}
