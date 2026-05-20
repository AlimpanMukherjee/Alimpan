class Solution {

    int func(int[] prices, int instock, int idx, int dp[][], int fees)
    {
        int n = prices.length;

        if (idx == n - 1) {

            if (instock == 1) {
                return prices[idx] - fees;
            }
            else {
                return 0;
            }
        }

        if (dp[instock][idx] != -1) {
            return dp[instock][idx];
        }

        int buy = Integer.MIN_VALUE;
        int notbuy = Integer.MIN_VALUE;

        if (instock == 1) {

            int sell = prices[idx] - fees + func(prices, 0, idx + 1, dp, fees);

            int notsell = func(prices, 1, idx + 1, dp, fees);

            return dp[instock][idx] = Math.max(sell, notsell);
        }

        else if (instock == 0) {

            buy = func(prices, 1, idx + 1, dp, fees) - prices[idx];

            notbuy = func(prices, 0, idx + 1, dp, fees);

            return dp[instock][idx] = Math.max(buy, notbuy);
        }

        return dp[instock][idx] = 0;
    }

    public int maxProfit(int[] prices, int fee) {

        if (prices.length == 1) {
            return 0;
        }

        int[][] dp = new int[2][prices.length + 1];

        for (int i = 0; i < 2; i++) {

            for (int k = 0; k <= prices.length; k++) {

                dp[i][k] = -1;
            }
        }

        int buy = func(prices, 1, 1, dp, fee) - prices[0];

        int notbuy = func(prices, 0, 1, dp, fee);

        return Math.max(buy, notbuy);
    }
}