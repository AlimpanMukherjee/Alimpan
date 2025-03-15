class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int f;

        int[][] dp = new int[m][n];

        for(int i = m - 1; i >= 0; i--) {
             for (int j = n - 1; j >= 0; j--){
                 int delta = dungeon[i][j];
                 if(i==m-1 && j==n-1)
                 {
                    dp[i][j]=Math.max(1,1-delta);
                 }
                 else{
                    if (j + 1 == n)f=dp[i+1][j];
                    else if (i + 1 == m)f=dp[i][j+1];
                    else f=Math.min(dp[i][j+1],dp[i+1][j]);
                    
                    dp[i][j]=Math.max(1,f-delta);
                 }
             }
        }
        return dp[0][0];
    }
}