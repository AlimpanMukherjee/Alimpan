// class Solution {
//     int check(int [][]grid,int i,int j,int k,int [][][]dp)
//     {
//         if(i<0 || j<0)return Integer.MIN_VALUE;
//         if((k==0) && grid[i][j]!=0) return dp[i][j][k]=Integer.MIN_VALUE;
//         if(i==0 && j==0)return dp[i][j][k]=grid[i][j];

        

//         if(grid[i][j]!=0)k--;
//         if(dp[i][j][k]!=-1)return dp[i][j][k];
//         int up=check(grid,i-1,j,k,dp);
//         int left=check(grid,i,j-1,k,dp);
//         if(up<0 && left<0)return dp[i][j][k]=Integer.MIN_VALUE;
//         return dp[i][j][k]=grid[i][j]+Math.max(up,left);

//     }
//     public int maxPathScore(int[][] grid, int k) {
        
//         int [][][]dp=new int[grid.length][grid[0].length][k+1];
//         for(int i=0;i<grid.length;i++)
//         {
//             for(int j=0;j<grid[0].length;j++)
//             {
//                 for(int x=0;x<=k;x++)
//                 {
//                     dp[i][j][x]=-1;
//                 }
//             }
//         }
//         dp[grid.length-1][grid[0].length-1][k]=check(grid,grid.length-1,grid[0].length-1,k,dp);
//         if(dp[grid.length-1][grid[0].length-1][k]==Integer.MIN_VALUE)return -1;
//         else return dp[grid.length-1][grid[0].length-1][k];
//     }
// }


class Solution {
    int check(int[][] grid, int i, int j, int k, int[][][] dp) {
        if (i < 0 || j < 0) return Integer.MIN_VALUE;
        if (k == 0 && grid[i][j] != 0) return Integer.MIN_VALUE;
        if (i == 0 && j == 0) return dp[i][j][k] = grid[i][j];

        if (dp[i][j][k] != -1) return dp[i][j][k];  // lookup BEFORE decrementing

        int newk = (grid[i][j] != 0) ? k - 1 : k;   // don't mutate k

        int up   = check(grid, i - 1, j, newk, dp);
        int left = check(grid, i, j - 1, newk, dp);

        
        // if (up   != Integer.MIN_VALUE) best = Math.max(best, up);
        // if (left != Integer.MIN_VALUE) best = Math.max(best, left);

        // if (best == Integer.MIN_VALUE) return dp[i][j][k] = Integer.MIN_VALUE;
        if(up<0 && left<0)return dp[i][j][k]=Integer.MIN_VALUE;
        return dp[i][j][k] = grid[i][j] +Math.max(up,left);
    }

    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];
        for (int[][] mat : dp)
            for (int[] row : mat)
                Arrays.fill(row, -1);

        int ans = check(grid, m - 1, n - 1, k, dp);
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}


// class Solution {
//     int check(int [][]grid,int i,int j,int k)
//     {
//         if(i<0 || j<0)return Integer.MIN_VALUE;
//         if((k==0) && grid[i][j]!=0) return Integer.MIN_VALUE;
//         if(i==0 && j==0)return grid[i][j];

//         if(grid[i][j]!=0)k--;

//         int up=grid[i][j]+check(grid,i-1,j,k);
//         int left=grid[i][j]+check(grid,i,j-1,k);
//         if(up<0 && left<0)return Integer.MIN_VALUE;
//         return Math.max(up,left);

//     }
//     public int maxPathScore(int[][] grid, int k) {
//         int ans=check(grid,grid.length-1,grid[0].length-1,k);
//         if(ans==Integer.MIN_VALUE)return -1;
//         else return ans;
//     }
// }