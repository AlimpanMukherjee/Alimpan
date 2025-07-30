class Solution {
    public boolean isValid(char [][]board,int row,int col,int n)
    {
        int r=row,c=col-1;
        while(c>=0)
        {
            if(board[r][c]=='Q') return false;
            c--;
        }
        r=row-1;
        c=col-1;
        while(r>=0 && c>=0)
        {
            if(board[r][c]=='Q') return false;
            r--;
            c--;
        }
        r=row+1;
        c=col-1;
        while(r<n && c>=0)
        {
            if(board[r][c]=='Q') return false;
            r++;
            c--;
        }
        return true;
    }
    public List<String> construct(char[][]board,int n)
    {
        List<String> res=new ArrayList<>();
        for(char[] row:board)
        {
            res.add(new String(row));
        }
        return res;
    }
    public void solve(int col,char [][]board,List<List<String>> ans,int n)
    {
        if(col==n)
        {
            ans.add(construct(board,n));
            return ;
        }
        for(int row=0;row<n;row++)
        {
            if(isValid(board,row,col,n))
            {
                board[row][col]='Q';
                solve(col+1,board,ans,n);
                board[row][col]='.';
            }
        }
    }
    public int totalNQueens(int n) {
        char [][]board=new char[n][n];
        List<List<String>> ans=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            Arrays.fill(board[i],'.');
        }
        solve(0,board,ans,n);
        return ans.size();
    }
}