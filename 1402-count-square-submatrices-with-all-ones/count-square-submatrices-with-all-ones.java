class Solution {
    public int countSquares(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            if(matrix[i][0]==1)dp[i][0]=1;
            else dp[i][0]=0;            
        }
        for(int i=0;i<m;i++)
        {
            if(matrix[0][i]==1)dp[0][i]=1;
            else matrix[0][i]=0;
        }
        int sum=0;
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {       
                if(matrix[i][j]==0)dp[i][j]=0;
                else
                {
                    int diag=dp[i-1][j-1];
                    int up=dp[i-1][j];
                    int left=dp[i][j-1];
                    int mini=Math.min(diag,Math.min(up,left));
                    dp[i][j]=1+mini;
                }
                //sum+=dp[i][j];
            }
        }  

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                sum+=dp[i][j];
            }
        }     
        return sum;
    }
}