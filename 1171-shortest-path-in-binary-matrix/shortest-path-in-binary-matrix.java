class Pair
{
    int x,y;
    Pair(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(n==1 && m==1 && grid[0][0]==0)return 1;
        Queue<Pair> q=new LinkedList<>();
        int visited[][]=new int[n][m];
        if(grid[0][0]==0)q.offer(new Pair(0,0));
        visited[0][0]=1;
        int level=1;
        int dir1[]={-1,0,1,0};
        int dir2[]={0,1,0,-1};
        
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int k=0;k<size;k++)
            {
                Pair p=q.poll();
                int x=p.x;
                int y=p.y;
                for(int i=0;i<4;i++)
                {
                    for(int j=0;j<4;j++)
                    {
                        int nr=x+dir1[i];
                        int nc=y+dir2[j];
                        if(nr<n && nr>=0 && nc<m && nc>=0 && visited[nr][nc]==0 && grid[nr][nc]==0)
                        {
                            q.offer(new Pair(nr,nc));
                            visited[nr][nc]=1;
                            if(nr==n-1 && nc==m-1)return level+1;
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}