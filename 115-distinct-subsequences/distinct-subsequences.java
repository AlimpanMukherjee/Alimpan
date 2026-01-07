class Solution {
    int f(String s,String t,int i1,int i2,int [][]dp)
    {
        
        if(i2<0)return 1;
        if(i1<0 && i2>=0)return 0;
        if(dp[i1][i2]!=-1)return dp[i1][i2];
        if(s.charAt(i1)==t.charAt(i2))
        {
            int take=f(s,t,i1-1,i2-1,dp);
            int ntake=f(s,t,i1-1,i2,dp);
            return dp[i1][i2]=take+ntake;
        }
        else
        {
            return dp[i1][i2]=f(s,t,i1-1,i2,dp);
        }

    }
    public int numDistinct(String s, String t) {
        int dp[][]=new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<t.length();j++)
            {
                dp[i][j]=-1;
            }
        }
        return f(s,t,s.length()-1,t.length()-1,dp);
    }
}