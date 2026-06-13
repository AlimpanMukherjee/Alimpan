class Solution {
    int check(int i, int j , String s,int [][]dp)
    {
        if(dp[i][j]!=-1)return dp[i][j];
        if(i==j)return dp[i][j]=1;
        if(i+1==j)
        {
            if(s.charAt(i)==s.charAt(j))return dp[i][j]=1;
            return dp[i][j]=0;
        }
        if(s.charAt(i)!=s.charAt(j))return dp[i][j]=0;
        int ans=0;
        if(s.charAt(i)==s.charAt(j)) ans=check(i+1,j-1,s,dp);
        return dp[i][j]=ans;
    }
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(check(i,j,s,dp)==1)count+=1;
                
            }
        }
        return count;
    }
}