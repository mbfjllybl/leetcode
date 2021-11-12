package Java.sudokuSolver;

class Solution {
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][][] cube = new boolean[3][3][9];
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int x = board[i][j] - '1';
                    row[i][x] = col[j][x] = cube[i / 3][j / 3][x] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int x, int y) {
        if (y == 9) {
            x++;
            y = 0;
        }
        if (x == 9) return true;
        if (board[x][y] != '.') return dfs(board, x, y + 1);
        for (int i = 1; i <= 9; i++) {
            if (row[x][i - 1] == false && col[y][i - 1] == false && cube[x / 3][y / 3][i - 1] == false) {
                row[x][i - 1] = col[y][i - 1] = cube[x / 3][y / 3][i - 1] = true;
                board[x][y] = (char)('0' + i);
                if (dfs(board, x, y + 1)) return true;
                board[x][y] = '.';
                row[x][i - 1] = col[y][i - 1] = cube[x / 3][y / 3][i - 1] = false;
            }
        }
        return false;
    }
}
