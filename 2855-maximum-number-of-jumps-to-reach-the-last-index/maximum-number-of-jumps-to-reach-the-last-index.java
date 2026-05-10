class Solution {
    public int func(int idx,int []nums,int target,int n,int dp[])
    {
        if(idx==n-1)return dp[idx]=0;
        int steps=Integer.MIN_VALUE;
        if(dp[idx]!=-1)return dp[idx];
        for(int j=idx+1;j<n;j++)
        {
            if((-target<=nums[j]-nums[idx]) &&(nums[j]-nums[idx]<=target))
            {
                steps=Math.max(func(j,nums,target,n,dp),steps);
            }
        }
        if(steps==-2)return Integer.MIN_VALUE;
        return dp[idx]=1+steps;
    }
    public int maximumJumps(int[] nums, int target) {
        int n=nums.length;
        int steps=Integer.MIN_VALUE;
        int dp[]=new int[n];
        for(int i=0;i<n;i++)
        {
            dp[i]=-1;
        }
        for(int i=1;i<n;i++)
        {
            if(-target<=nums[i]-nums[0] && nums[i]-nums[0] <=target)
            {
                steps=Math.max(func(i,nums,target,n,dp),steps);
            }
        }
        if(steps<0)return -1;
        return 1+steps;
    }
}