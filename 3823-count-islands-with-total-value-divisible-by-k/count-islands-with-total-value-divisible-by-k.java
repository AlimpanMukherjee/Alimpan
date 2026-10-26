class Solution {
    class Pair{
        int x,y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    long func(int[][] grid, int[][] visited, int i, int j, int k) {
        int n = grid.length;
        int m = grid[0].length;
        long sum = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        sum += grid[i][j];
        visited[i][j] = 1;

        int[] dir1 = {-1, 0, 1, 0};
        int[] dir2 = {0, -1, 0, 1};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for (int a = 0; a < 4; a++) {
                int dx = x + dir1[a];
                int dy = y + dir2[a];

                if (dx >= 0 && dy >= 0 && dx < n && dy < m
                        && visited[dx][dy] == 0 && grid[dx][dy] != 0) {
                    visited[dx][dy] = 1;
                    sum += grid[dx][dy];
                    q.offer(new Pair(dx, dy));
                }
            }
        }

        return sum % k;
    }

    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0 && visited[i][j] == 0) {
                    long ans = func(grid, visited, i, j, k);
                    if (ans == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}