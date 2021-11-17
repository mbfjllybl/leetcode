package Java.insertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {{newInterval[0], newInterval[1]}};
        }
        List<int[]> list = new ArrayList<>();
        boolean f = false;
        for (int i = 0; i < intervals.length; i++) {
            if (f == false && intervals[i][0] >= newInterval[0]) {
                f = true;
                if (newInterval[1] < intervals[i][0]) {
                    list.add(newInterval);
                    list.add(intervals[i]);
                    continue;
                }
                intervals[i][0] = Math.min(newInterval[0], intervals[i][0]);
                intervals[i][1] = Math.max(newInterval[1], intervals[i][1]);
            }
            if (f == false && intervals[i][0] < newInterval[0] && intervals[i][1] >= newInterval[0]) {
                f = true;

                intervals[i][0] = Math.min(newInterval[0], intervals[i][0]);
                intervals[i][1] = Math.max(newInterval[1], intervals[i][1]);

            }
            int j = i + 1;
            int mx = intervals[i][1];
            while (j < intervals.length && intervals[j][0] <= mx) {
                mx = Math.max(mx, intervals[j][1]);
                j++;
            }
            list.add(new int[]{intervals[i][0], mx});
            i = j - 1;
        }
        if (f == false) {
            list.add(newInterval);
        }
        return list.toArray(new int[list.size() - 1][2]);
    }
}
