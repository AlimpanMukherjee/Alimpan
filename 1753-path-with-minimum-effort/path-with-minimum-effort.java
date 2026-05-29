class Tuple{
    int dist,x,y;

    Tuple(int dist, int x ,int y)
    {
        this.dist=dist;
        this.x=x;
        this.y=y;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {

        PriorityQueue<Tuple> pq =
            new PriorityQueue<>((a,b) -> a.dist - b.dist);

        int n=heights.length;
        int m=heights[0].length;

        int [][]dp=new int[n][m];

        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        pq.offer(new Tuple(0,0,0));

        dp[0][0]=0;

        int dir1[]={-1,0,1,0};
        int dir2[]={0,1,0,-1};

        while(!pq.isEmpty())
        {
            Tuple t=pq.poll();

            int dist=t.dist;
            int x=t.x;
            int y=t.y;

            for(int i=0;i<4;i++)
            {
                int nr=x+dir1[i];
                int nc=dir2[i]+y;
                if(nr==x && nc==y)continue;
                if(nr>=0 && nc>=0 && nr<n && nc<m)
                {
                    int newdist=Math.max(dp[x][y],Math.abs((heights[x][y]-heights[nr][nc])));
                    if(dp[nr][nc] >  newdist)
                    {
                        pq.offer(new Tuple(Math.abs((heights[x][y]-heights[nr][nc])),nr,nc));                         
                        dp[nr][nc] =newdist;
                    }
                }
            }
        }

        return dp[n-1][m-1];
    }
}