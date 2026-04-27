import java.util.*;

class Solution {

    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public boolean check(int curr, int next, int i) {

    // 0 = UP, 1 = RIGHT, 2 = DOWN, 3 = LEFT

    // ---- CURRENT CELL CHECK ----
    if (curr == 1 && (i == 0 || i == 2)) return false; // L-R
    if (curr == 2 && (i == 1 || i == 3)) return false; // U-D
    if (curr == 3 && (i == 0 || i == 1)) return false; // L-D
    if (curr == 4 && (i == 0 || i == 3)) return false; // R-D
    if (curr == 5 && (i == 1 || i == 2)) return false; // L-U
    if (curr == 6 && (i == 2 || i == 3)) return false; // R-U

    // ---- NEXT CELL CHECK ----

    if (i == 0) { // UP → next must allow DOWN
        return (next == 2 || next == 3 || next == 4);
    }

    if (i == 1) { // RIGHT → next must allow LEFT
        return (next == 1 || next == 3 || next == 5);
    }

    if (i == 2) { // DOWN → next must allow UP
        return (next == 2 || next == 5 || next == 6);
    }

    if (i == 3) { // LEFT → next must allow RIGHT
        return (next == 1 || next == 4 || next == 6);
    }

    return false;
}
    public boolean hasValidPath(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int[][] explored = new int[n][m];

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));

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
                
                if (check(grid[currx][curry],grid[nx][ny],i)) {
                    q.offer(new Pair(nx, ny));
                }
            }
        }

        return explored[n - 1][m - 1] == 1;
    }
}