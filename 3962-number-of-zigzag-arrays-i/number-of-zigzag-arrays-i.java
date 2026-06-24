class Solution {
    static final int mod = 1000000007;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        int dp[][][] = new int[n][m + 2][2];

        for (int i = 1; i <= m; i++) {
            dp[n - 1][i][0] = 1;
            dp[n - 1][i][1] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {

            long cumsum1[] = new long[m + 2];
            long cumsum2[] = new long[m + 2];

            for (int j = 1; j <= m; j++) {
                cumsum1[j] = (cumsum1[j - 1] + dp[i + 1][j][1]) % mod;
                cumsum2[j] = (cumsum2[j - 1] + dp[i + 1][j][0]) % mod;
            }

            for (int prevVal = 1; prevVal <= m; prevVal++) {
                dp[i][prevVal][0] = (int)cumsum1[prevVal - 1];
                // }

                // for(int nextVal = prevVal + 1; nextVal <= m; nextVal++)
                // {
                dp[i][prevVal][1] = (int)((cumsum2[m] - cumsum2[prevVal] + mod) % mod);
                // }
            }
        }

        long ans = 0;

        for (int i = 1; i <= m; i++) {
            ans = (ans + dp[0][i][0]) % mod;
            ans = (ans + dp[0][i][1]) % mod;
        }

        return (int)ans;
    }
}