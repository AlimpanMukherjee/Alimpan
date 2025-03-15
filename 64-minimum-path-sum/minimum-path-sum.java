class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c= grid[0].length;
        int i,j;

        if(r==1 && c==1)
        {
            return grid[0][0];
        }

        for(j=1;j<c;j++)
        {
            grid[0][j]=grid[0][j]+grid[0][j-1];
        }
        for(i=1;i<r;i++)
        {
            grid[i][0]=grid[i][0]+grid[i-1][0];
        }


        for(i=1;i<r;i++)
        {
            for(j=1;j<c;j++)
            {
                grid[i][j]=grid[i][j]+Math.min(grid[i][j-1],grid[i-1][j]);
            }
        }

        return grid[r-1][c-1];

    }
}