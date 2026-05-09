class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        
        int n=grid.length;
        int m=grid[0].length;

        int left=0;
        int right=m-1;
        int up=0;
        int down=n-1;

        while((left<right) && (up<down))
        {
            int rows=down-up+1;
            int cols=right-left+1;

            int len=2*(rows+cols-2);

            int rot=k%len;

            for(int r=1;r<=rot;r++)
            {
                int temp=grid[up][left];

                for(int j=left;j<right;j++)
                {
                    grid[up][j]=grid[up][j+1];
                }

                for(int j=up;j<down;j++)
                {
                    grid[j][right]=grid[j+1][right];
                }

                for(int j=right;j>left;j--)
                {
                    grid[down][j]=grid[down][j-1];
                }

                for(int j=down;j>up+1;j--)
                {
                    grid[j][left]=grid[j-1][left];
                }

                grid[up+1][left]=temp;
            }

            left++;
            right--;
            up++;
            down--;
        }

        return grid;
    }
}