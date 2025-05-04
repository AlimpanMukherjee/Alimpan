class Solution {

    boolean check(int[][] board, int i, int j) {
        int val = board[i][j];
        if (val == 0) return true;

        // Check column
        for (int a = 0; a < 9; a++) {
            if (a != i && board[a][j] == val) return false;
        }

        // Check row
        for (int a = 0; a < 9; a++) {
            if (a != j && board[i][a] == val) return false;
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] intBoard = new int[rows][cols];

        // Convert char to int
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.') {
                    intBoard[i][j] = 0;
                } else {
                    intBoard[i][j] = board[i][j] - '0';
                }
            }
        }

        // Box checks
        int[] box1 = new int[10];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                int v = intBoard[i][j];
                if (v != 0) {
                    if (box1[v] == 1) return false;
                    box1[v] = 1;
                }
            }

        int[] box2 = new int[10];
        for (int i = 0; i < 3; i++)
            for (int j = 3; j < 6; j++) {
                int v = intBoard[i][j];
                if (v != 0) {
                    if (box2[v] == 1) return false;
                    box2[v] = 1;
                }
            }

        int[] box3 = new int[10];
        for (int i = 0; i < 3; i++)
            for (int j = 6; j < 9; j++) {
                int v = intBoard[i][j];
                if (v != 0) {
                    if (box3[v] == 1) return false;
                    box3[v] = 1;
                }
            }

        int[] box4 = new int[10];
        for (int i = 3; i < 6; i++)
            for (int j = 0; j < 3; j++) {
                int v = intBoard[i][j];
                if (v != 0) {
                    if (box4[v] == 1) return false;
                    box4[v] = 1;
                }
            }

        int[] box5 = new int[10];
        for (int i = 3; i < 6; i++)
            for (int j = 3; j < 6; j++) {
                int v = intBoard[i][j];
                if (v != 0) {
                    if (box5[v] == 1) return false;
                    box5[v] = 1;
                }
            }

        int[] box6 = new int[10];
        for (int i = 3; i < 6; i++)
            for (int j = 6; j < 9; j++) {
                int v = intBoard[i][j];
                if (v != 0) {
                    if (box6[v] == 1) return false;
                    box6[v] = 1;
                }
            }

        int[] box7 = new int[10];
        for (int i = 6; i < 9; i++)
            for (int j = 0; j < 3; j++) {
                int v = intBoard[i][j];
                if (v != 0) {
                    if (box7[v] == 1) return false;
                    box7[v] = 1;
                }
            }

        int[] box8 = new int[10];
        for (int i = 6; i < 9; i++)
            for (int j = 3; j < 6; j++) {
                int v = intBoard[i][j];
                if (v != 0) {
                    if (box8[v] == 1) return false;
                    box8[v] = 1;
                }
            }

        int[] box9 = new int[10];
        for (int i = 6; i < 9; i++)
            for (int j = 6; j < 9; j++) {
                int v = intBoard[i][j];
                if (v != 0) {
                    if (box9[v] == 1) return false;
                    box9[v] = 1;
                }
            }

        // Row and column checks
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!check(intBoard, i, j)) return false;
            }
        }

        return true;
    }
}
