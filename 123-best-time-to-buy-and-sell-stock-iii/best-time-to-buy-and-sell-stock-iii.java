class Solution {
    int func(int prices[], int k, int isStock, int i, int n,int [][][]dp) {
        
        if (i == n - 1) {
            if (isStock == 1) return dp[i][isStock][k]=prices[i];
            if (isStock == 0) return dp[i][isStock][k]=0;
        }

        if (isStock == 0 && k == 0) return dp[i][isStock][k]=0;

        if(dp[i][isStock][k]!=-1)return dp[i][isStock][k];

        if (isStock == 1) {
            int available = k;
            int idx = i;

            int sell = prices[i] + func(prices, available, 0, idx + 1, n,dp);
            int notSell = func(prices, available, 1, idx + 1, n,dp);

            return dp[i][isStock][k]=Math.max(sell, notSell);
        }

        if (isStock == 0) {
            int available = k;
            int idx = i;

            int buy = -prices[i] + func(prices, available - 1, 1, idx + 1, n,dp);
            int notBuy = func(prices, available, 0, idx + 1, n,dp);

            return dp[i][isStock][k]=Math.max(buy, notBuy);
        }

        return dp[i][isStock][k]=0;   
    }
    public int maxProfit(int[] prices) {
        int dp[][][]=new int [prices.length][2][3];
        for(int i=0;i<prices.length;i++)
        {
            for(int j=0;j<2;j++)
            {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return func(prices, 2, 0, 0, prices.length,dp);
    }
}


