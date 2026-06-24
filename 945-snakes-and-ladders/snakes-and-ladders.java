class Pair {
    int val, count;

    Pair(int val, int count) {
        this.val = val;
        this.count = count;
    }
}

class Solution {
    public int snakesAndLadders(int[][] board) {

        int n = board.length;

        Map<Integer, Integer> map = new HashMap<>();

        int cell = 1;
        boolean leftToRight = true;

        for (int i = n - 1; i >= 0; i--) {

            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != -1) {
                        map.put(cell, board[i][j]);
                    }
                    cell++;
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    if (board[i][j] != -1) {
                        map.put(cell, board[i][j]);
                    }
                    cell++;
                }
            }

            leftToRight = !leftToRight;
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(1, 0));

        int[] visited = new int[n * n + 1];
        visited[1] = 1;

        while (!q.isEmpty()) {

            Pair p = q.poll();

            int curr = p.val;
            int count = p.count;

            if (curr == n * n)
                return count;

            for (int i = 1; i <= 6; i++) {

                int newval = curr + i;

                if (newval > n * n)
                    continue;

                int next = map.getOrDefault(newval, newval);

                if (visited[next] == 1)
                    continue;

                visited[next] = 1;
                q.offer(new Pair(next, count + 1));
            }
        }

        return -1;
    }
}