class Pair{
    int x,y;
    Pair(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int visited[][]=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(grid[i][0]==1 && visited[i][0]==0)
            {
                visited[i][0]=1;
                q.offer(new Pair(i,0));
            }
            if(grid[i][m-1]==1 && visited[i][m-1]==0)
            {
                visited[i][m-1]=1;
                q.offer(new Pair(i,m-1));
            }
        }
        for(int j=0;j<m;j++)
        {
            if(grid[0][j]==1 && visited[0][j]==0)
            {
                visited[0][j]=1;
                q.offer(new Pair(0,j));
            }
            if(grid[n-1][j]==1 && visited[n-1][j]==0)
            {
                visited[n-1][j]=1;
                q.offer(new Pair(n-1,j));
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
                if(nr<n && nc<m && nr>=0 && nc>=0 && visited[nr][nc]==0 && grid[nr][nc]==1)
                {
                    visited[nr][nc]=1;
                    q.offer(new Pair(nr,nc));
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j]==0 && grid[i][j]==1)count++;
            }
        }
        return count;
    }
}