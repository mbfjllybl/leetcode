package Java.validSudoku;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap[] map1 = new HashMap[10];
        HashMap[] map2 = new HashMap[10];
        HashMap[] map3 = new HashMap[10];
        for (int i = 1; i <= 9; i++) {
            map1[i] = new HashMap<Integer, Integer>();
            map2[i] = new HashMap<Integer, Integer>();
            map3[i] = new HashMap<Integer, Integer>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int x = Integer.parseInt(board[i][j] + "");
                i++;
                j++;
                if (map1[i].containsKey(x)) return false;
                if (map2[j].containsKey(x)) return false;
                if (map3[((i - 1) / 3 + 1 - 1) * 3 + (j - 1) / 3 + 1].containsKey(x)) return false;
                map1[i].put(x, 1);
                map2[j].put(x, 1);
                map3[((i - 1) / 3 + 1 - 1) * 3 + (j - 1) / 3 + 1].put(x, 1);
                i--;
                j--;
            }
        }
        return true;
    }
}
