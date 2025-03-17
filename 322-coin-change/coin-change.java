class Solution {
    public int coinChange(int[] coins, int n) {


        int[] amounts = new int[n + 1];
        if(n==0) return 0;


        int least_value_coin = coins[0];
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] < least_value_coin) {
                least_value_coin = coins[i];
            }
        }


        amounts[0] = 0;
        for (int i = 1; i <= n; i++) {
            amounts[i] = Integer.MAX_VALUE;
        }


        if (n < least_value_coin) {
            return -1;
        }


        for (int i = least_value_coin; i <= n; i++) {
            int least = Integer.MAX_VALUE;
            for (int coin : coins) {
                int amount_to_make=i;
                int remainder=amount_to_make-coin;
            if(coin<=i&&amounts[remainder]!=Integer.MAX_VALUE) {
                    int coin_choice = 1 + amounts[remainder];
                    least = Math.min(coin_choice, least);
                }
            }
            amounts[i] = least;
        }


        return(amounts[n] == Integer.MAX_VALUE)?-1:amounts[n];
    }
}