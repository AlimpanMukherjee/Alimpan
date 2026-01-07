class Solution {


    public boolean isMatch(String s, String p) {
        //return f(s, p, s.length() - 1, p.length() - 1);
        int n=s.length();
        int m=p.length();
        boolean dp[][]=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<m+1;i++)
        {
            boolean allstar=true;
            for(int k=1;k<=i;k++)
            {
                if(p.charAt(k-1)!='*'){
                    allstar=false;
                    break;
                }
            }
            dp[0][i]=allstar;
        }

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?') dp[i][j]=dp[i-1][j-1]; 

                else if (p.charAt(j-1) == '*') dp[i][j]=dp[i-1][j]||dp[i][j-1];

            }
        }
        return dp[n][m];
    }
}
