class Solution {

    public int func(int[] prices, int instock, int lastsold, int idx,int dp[][][]) {

        int n = prices.length;

        if (idx == n - 1) {

            if (instock == 1) {
                return prices[idx];
            }
            else {
                return 0;
            }
        }

        if(dp[instock][lastsold+1][idx]!=-1)return dp[instock][lastsold+1][idx];
        int buy = Integer.MIN_VALUE;
        int notbuy = Integer.MIN_VALUE;

        if (instock == 1) {

            int sell = prices[idx] + func(prices, 0, idx, idx + 1,dp);

            int notsell = func(prices, 1, lastsold, idx + 1,dp);

            return dp[instock][lastsold+1][idx]=Math.max(sell, notsell);
        }

        else if (instock == 0) {

            if (lastsold == idx - 1) {

                buy = Integer.MIN_VALUE;
            }

            else {

                buy = func(prices, 1, lastsold, idx + 1,dp) - prices[idx];
            }

            notbuy = func(prices, 0, lastsold, idx + 1,dp);

            return dp[instock][lastsold+1][idx]=Math.max(buy, notbuy);
        }

        return dp[instock][lastsold+1][idx]=0;
    }

    public int maxProfit(int[] prices) {

        // func(prices, instock, lastsold, idx)
        if(prices.length==1)return 0;
        

        int [][][]dp=new int[2][prices.length+2][prices.length+1];
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<=prices.length+1;j++)
            {
                for(int k=0;k<=prices.length;k++)
                {
                    dp[i][j][k]=-1;
                }
            }
        }
        int buy = func(prices, 1, -1, 1,dp) - prices[0];

        int notbuy = func(prices, 0, -1, 1,dp);

        return Math.max(buy, notbuy);
    }
}