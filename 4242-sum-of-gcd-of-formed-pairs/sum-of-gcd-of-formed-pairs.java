class Solution {
    int func(int a,int b)
    {
        if(b!=0)
        {
            return func(b,a%b);
        }
        return a;

    }
    public long gcdSum(int[] nums) {
        int prefix[]=new int[nums.length];
        int maxi=nums[0];
        prefix[0]=maxi;
        for(int i=1;i<nums.length;i++)
        {
            maxi=Math.max(maxi,nums[i]);
            prefix[i]=func(nums[i],maxi);
        }
        Arrays.sort(prefix);
        long ans=0;
        int i=0;
        int j=nums.length-1;
        while(i<j)
        {
            ans+=func(prefix[i],prefix[j]);
            i++;
            j--;
        }
        return ans;

    }
}