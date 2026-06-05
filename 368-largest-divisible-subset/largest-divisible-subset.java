class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        int hash[]=new int[n];
        Arrays.fill(dp,1);
        int maxi=0;
        int idx=0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++)hash[i]=i;
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]%nums[j]==0 || nums[j]%nums[i]==0)
                {
                    if(dp[i]<dp[j]+1)
                    {
                        dp[i]=dp[j]+1;
                        hash[i]=j;
                    }
                    if(maxi<dp[i])
                    {
                        maxi=dp[i];
                        idx=i;
                    }
                }
            }
        }
        int curr=idx;
        while(hash[curr]!=curr)
        {
            ans.add(nums[curr]);
            curr=hash[curr];
        }
        ans.add(nums[curr]);
        Collections.reverse(ans);
        return ans;
    }
}