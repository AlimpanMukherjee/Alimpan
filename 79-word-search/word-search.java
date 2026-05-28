class Solution {
    boolean func(int r,int c,char [][]board,int [][]visited,int idx,StringBuilder ans,String word,int n,int m)
    {
        visited[r][c]=1;
        ans.append(board[r][c]);

        if(ans.toString().equals(word))return true;

        int []dir1={-1,0,1,0};
        int []dir2={0,1,0,-1};

        for(int i=0;i<4;i++)
        {
            int nr=dir1[i]+r;
            int nc=dir2[i]+c;

            if(nr>=0 && nr<n && nc<m && nc>=0 && visited[nr][nc]==0 && board[nr][nc]==word.charAt(idx))
            {
                boolean temp=func(nr,nc,board,visited,idx+1,ans,word,n,m);

                if(temp==true)return true;
            }
        }

        visited[r][c]=0;
        ans.deleteCharAt(ans.length()-1);

        return false;
    }

    public boolean exist(char[][] board, String word) {

        int n=board.length;
        int m=board[0].length;

        int [][]visited=new int[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    boolean ans=func(i,j,board,visited,1,new StringBuilder(),word,n,m);

                    if(ans==true)return ans;
                }
            }
        }

        return false;
    }
}