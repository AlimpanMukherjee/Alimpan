class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int delta = dungeon[i][j];

                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(1, 1 - delta);
                } else {
                    int f = Integer.MAX_VALUE;

                    if (j + 1 < n) f = dp[i][j + 1]; // Right cell
                    if (i + 1 < m) f = Math.min(f, dp[i + 1][j]); // Down cell

                    dp[i][j] = Math.max(1, f - delta);
                }
            }
        }
        return dp[0][0];
    }
}
