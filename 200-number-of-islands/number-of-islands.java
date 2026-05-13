class Solution {

    public void check(char[][] grid, int visited[][], int i, int j)
    {
        int n = grid.length;
        int m = grid[0].length;

        int dir1[] = {-1, 0, 1, 0};
        int dir2[] = {0, 1, 0, -1};

        visited[i][j] = 1;

        for(int k = 0; k < 4; k++)
        {
            int nr = i + dir1[k];
            int nc = j + dir2[k];

            if(nr < n && nr >= 0 && nc < m && nc >= 0
               && visited[nr][nc] != 1
               && grid[nr][nc] == '1')
            {
                check(grid, visited, nr, nc);
            }
        }

        return;
    }

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int visited[][] = new int[n][m];

        int count = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == '1' && visited[i][j] == 0)
                {
                    count++;
                    check(grid, visited, i, j);
                }
            }
        }

        return count;
    }
}