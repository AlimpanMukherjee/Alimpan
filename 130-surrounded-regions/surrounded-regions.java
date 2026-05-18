

class Pair{
    int x,y;

    Pair(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}

class Solution {

    public void solve(char[][] board) {

        Queue<Pair> q=new LinkedList<>();

        int n=board.length;

        int m=board[0].length;

        for(int i=1;i<n-1;i++)
        {
            for(int j=1;j<m-1;j++)
            {
                if(board[i][j]=='O')board[i][j]='Y';
            }
        }

        int visited[][]=new int[n][m];

        for(int i=0;i<n;i++)
        {
            if(board[i][0]=='O' && visited[i][0]==0)
            {
                q.offer(new Pair(i,0));

                visited[i][0]=1;
            }

            if(board[i][m-1]=='O' && visited[i][m-1]==0)
            {
                q.offer(new Pair(i,m-1));

                visited[i][m-1]=1;
            }
        }

        for(int i=0;i<m;i++)
        {
            if(board[0][i]=='O' && visited[0][i]==0)
            {
                q.offer(new Pair(0,i));

                visited[0][i]=1;
            }

            if(board[n-1][i]=='O' && visited[n-1][i]==0)
            {
                q.offer(new Pair(n-1,i));

                visited[n-1][i]=1;
            }
        }

        int dir1[]={-1,0,1,0};

        int dir2[]={0,1,0,-1};

        while(!q.isEmpty())
        {
            Pair p=q.poll();

            int x=p.x;

            int y=p.y;

            for(int i=0;i<4;i++)
            {
                int nr=x+dir1[i];

                int nc=y+dir2[i];

                if(nr<n && nc<m && nr>=0 && nc>=0 && visited[nr][nc]==0 && board[nr][nc]=='Y')
                {
                    visited[nr][nc]=1;

                    board[nr][nc]='O';

                    q.offer(new Pair(nr,nc));
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='Y')
                {
                    board[i][j]='X';
                }
            }
        }

        return;
    }
}