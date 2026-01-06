class Solution {
    public boolean canPartition(int[] arr) {
        int sum=0;
        int k=0;
        int n=arr.length;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        if(sum%2!=0)return false;
        else  k=sum/2;
        boolean [][]dp=new boolean[n][k+1];
        for(int i=0;i<n;i++)
        {
            dp[i][0]=true;
        }
        if(arr[0]<=k)dp[0][arr[0]]=true;
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<=k;j++)
            {
                boolean ntake=dp[i-1][j];
                boolean take=false;
                if(arr[i]<=j)take=dp[i-1][j-arr[i]];
                dp[i][j]= take||ntake;
            }
        }
        return dp[n-1][k];
    }
}