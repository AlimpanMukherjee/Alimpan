class Solution {
    int mod=1000000007;
    int func(int i,int j,int grid[][],int r,int dp[][][])
    {
        int n=grid.length;
        int m=grid[0].length;
        if(dp[i][j][r]!=-1)return dp[i][j][r];
        if(i==n-1 && j==m-1)return dp[i][j][r]=1;
        if(i>=n || j>=m || i<0 || j<0)return 0;
        int right=0;
        int down=0;
        if(grid[i][j]==1 && r==1)
        {
             right=0;
             down=func(i+1,j,grid,0,dp);
        }
        else if(grid[i][j]==1 && r==0)
        {
             down=0;
             right=func(i,j+1,grid,1,dp);
        }
        else
        {
             right=func(i,j+1,grid,1,dp);
             down=func(i+1,j,grid,0,dp);
        }
        return dp[i][j][r]=(right+down)%mod;

    }
    public int uniquePaths(int[][] grid) {
        //int count=0;
        int dp[][][]=new int[grid.length+1][grid[0].length+1][2];
        for(int i=0;i<grid.length+1;i++)
        {
            for(int j=0;j<grid[0].length;j++)Arrays.fill(dp[i][j],-1);
        }
        int right=func(0,1,grid,1,dp);
        int down=func(1,0,grid,0,dp);
        return (down+right)%mod;
    }
}