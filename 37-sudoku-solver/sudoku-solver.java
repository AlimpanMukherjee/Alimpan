class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char val = '1'; val <= '9'; val++) {
                        if (isValid(board, i, j, val)) {
                            board[i][j] = val;
                            if (solve(board))
                                return true; 
                            board[i][j] = '.'; 
                        }
                    }
                    return false;
                }
            }
        }
        return true; 
    }

    public boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch)
                return false; 
            if (board[i][col] == ch)
                return false; 
        }
        int rowstart = 3*(row/3);
        int colstart=3*(col/3);

        for(int i=rowstart;i<rowstart+3;i++)
        {
            for(int j=colstart;j<colstart+3;j++)
            {
                if(board[i][j]==ch)return false;
            }
        }
        return true;
    }
}
