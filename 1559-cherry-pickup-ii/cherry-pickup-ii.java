class Solution {
    int func(int i,int j1,int j2,int grid[][],int n,int m,int dp[][][])
    {
        if(i==n-1)return dp[i][j1][j2]=grid[i][j1]+grid[i][j2];
        //visited[i][j1]=1;
        //if(visited[i][j2]==0)visited[i2][j2]=1;
        //else return Integer.MIN_VALUE;
        if(dp[i][j1][j2]!=-1)return dp[i][j1][j2];
        int sum=grid[i][j1]+grid[i][j2];
        int a=Integer.MIN_VALUE;
        for(int k1=j1-1;k1<=j1+1;k1++)
        {
            for(int k2=j2-1;k2<=j2+1;k2++)
            {
                if(k1==k2)continue;
                if( k1<0 || k2<0 || k1>m-1 || k2>m-1)continue;
                a=Math.max(a,func(i+1,k1,k2,grid,n,m,dp));
            }
        }
        //visited[i][j1]=0;
        //visited[i][j2]=0;
        //sum-=(grid[i][j1]+grid[i][j2]);
        return dp[i][j1][j2]=a+sum;
    }
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [][][]dp=new int[n][m][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                for(int k=0;k<m;k++)
                {
                    dp[i][j][k]=-1;
                }
            }
        }
        //int visited[][]=new int[n][m];
        //int dp[][]=new int[][];
        return func(0,0,m-1,grid,n,m,dp);
    }
}