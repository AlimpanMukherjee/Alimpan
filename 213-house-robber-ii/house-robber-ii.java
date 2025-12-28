class Solution {
    public int rob(int[] nums) {
       int n=nums.length;
       if(n==0)return 0;
       if(n==1)return nums[0];
       if(n==2)return Math.max(nums[0],nums[1]);
       int []dp=new int[n-1];
       dp[0]=nums[0];
       for(int i=1;i<n-1;i++)
       {
            int taken=nums[i]+(i-2>=0?dp[i-2]:0);
            int ntaken=dp[i-1];
            dp[i]=Math.max(taken,ntaken);
       } 
       int []dp1=new int[n];
       dp1[1]=nums[1];
       for(int i=2;i<n;i++)
        {
            int taken=nums[i]+(i-2>=1?dp1[i-2]:0);
            int ntaken=dp1[i-1];
            dp1[i]=Math.max(taken,ntaken);
        }
      return Math.max(dp[n-2],dp1[n-1]); 
    }
}