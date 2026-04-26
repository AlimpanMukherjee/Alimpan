import java.util.*;

class Solution {
    class Pair {
        int x, y, px, py;
        Pair(int x, int y, int px, int py) {
            this.x = x;
            this.y = y;
            this.px = px;
            this.py = py;
        }
    }

    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 1) continue;

                Stack<Pair> st = new Stack<>();
                st.push(new Pair(i, j, -1, -1));

                while (!st.isEmpty()) {
                    Pair p = st.pop();
                    int x = p.x;
                    int y = p.y;
                    int px = p.px;
                    int py = p.py;

                    visited[x][y] = 1;

                    for (int k = 0; k < 4; k++) {
                        int nx = dir[k][0] + x;
                        int ny = dir[k][1] + y;

                        if (nx >= n || nx < 0 || ny < 0 || ny >= m) continue;
                        if (grid[x][y] != grid[nx][ny]) continue;

                        if (visited[nx][ny] == 0)
                            st.push(new Pair(nx, ny, x, y));
                        else if (visited[nx][ny] == 1 && (nx != px || ny != py))
                            return true;
                    }
                }
            }
        }
        return false;
    }
}