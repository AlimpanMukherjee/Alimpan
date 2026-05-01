class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        int []dp=new int[n];
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
        }

        for(int i=0;i<n;i++)
        {
            dp[0]+=i*nums[i];
        }
        
        for(int i=1;i<n;i++)
        {
            dp[i]=dp[i-1]-(sum-nums[i-1])+(nums[i-1]*(n-1));
        }
        int ans=dp[0];
        for(int i=1;i<n;i++)
        {
            ans=Math.max(ans,dp[i]);
        }
        return ans;

    }
}