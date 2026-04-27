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
public boolean check(int[][] grid, int nx, int ny, int px, int py, int i) {

    int curr = grid[px][py];
    int next = grid[nx][ny];

    // Directions:
    // 0 = UP, 1 = RIGHT, 2 = DOWN, 3 = LEFT

    // Check if current cell allows movement in direction i
    if (curr == 1 && (i != 1 && i != 3)) return false; // L-R
    if (curr == 2 && (i != 0 && i != 2)) return false; // U-D
    if (curr == 3 && (i != 3 && i != 2)) return false; // L-D
    if (curr == 4 && (i != 1 && i != 2)) return false; // R-D
    if (curr == 5 && (i != 3 && i != 0)) return false; // L-U
    if (curr == 6 && (i != 1 && i != 0)) return false; // R-U

    // Now check if next cell allows entry from opposite direction
    int opp = (i + 2) % 4;

    if (next == 1 && (opp == 1 || opp == 3)) return true;
    if (next == 2 && (opp == 0 || opp == 2)) return true;
    if (next == 3 && (opp == 3 || opp == 2)) return true;
    if (next == 4 && (opp == 1 || opp == 2)) return true;
    if (next == 5 && (opp == 3 || opp == 0)) return true;
    if (next == 6 && (opp == 1 || opp == 0)) return true;

    return false;
}
    public boolean hasValidPath(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int[][] explored = new int[n][m];

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, -1, -1));

        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            int currx = curr.x;
            int curry = curr.y;

            if (explored[currx][curry] == 1) continue;
            explored[currx][curry] = 1;

            for (int i = 0; i < 4; i++) {
                int nx = currx + dir[i][0];
                int ny = curry + dir[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (check(grid, nx, ny, currx, curry, i)) {
                    q.offer(new Pair(nx, ny, currx, curry));
                }
            }
        }

        return explored[n - 1][m - 1] == 1;
    }
}