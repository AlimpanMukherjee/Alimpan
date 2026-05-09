class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        

            int mat[][]=new int[n][m];

            int left=0;
            int right=m-1;
            int up=0;
            int down=n-1;

            while((left<right) && (up<down))
            {
                int r=down-up+1;
                int c=right-left+1;
                int t=k%(2*(r+c-2));
                for(int i=0;i<t;i++)
                {
                    for(int j=right;j>left;j--)
                    {
                        mat[up][j-1]=grid[up][j];
                    }

                    for(int j=up;j<down;j++)
                    {
                        mat[j+1][left]=grid[j][left];
                    }

                    for(int j=left;j<right;j++)
                    {
                        mat[down][j+1]=grid[down][j];
                    }

                    for(int j=down;j>up;j--)
                    {
                        mat[j-1][right]=grid[j][right];
                    }
                    for(int x=0;x<n;x++)
                    {
                        for(int y=0;y<m;y++)
                        {
                            if(mat[x][y]!=0)
                            {
                                grid[x][y]=mat[x][y];
                            }
                        }
                    }

                }
                
                left++;
                right--;
                up++;
                down--;
            }
        
        return grid;
    }
}