class Solution {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]=new int[n][m];
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<m;i++)
        {
            if(matrix[0][i]=='0') dp[0][i]=0;
            else dp[0][i]=1;
            maxi=Math.max(maxi,dp[0][i]);
        }
        for(int i=0;i<n;i++)
        {
            if(matrix[i][0]=='0')dp[i][0]=0;            
            else dp[i][0]=1;
            maxi=Math.max(maxi,dp[i][0]);
        }
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(matrix[i][j]=='0')dp[i][j]=0;
                else
                {
                    int up=dp[i-1][j];
                    int left=dp[i][j-1];
                    int diag=dp[i-1][j-1];
                    dp[i][j]=1+Math.min(diag,Math.min(left,up));
                    maxi=Math.max(maxi,dp[i][j]);
                }
            }
        }
        return maxi*maxi;
    }
}