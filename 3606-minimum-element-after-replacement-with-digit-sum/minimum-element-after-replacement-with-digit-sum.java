class Solution {
    int func(int n)
    {
        int sum=0;
        while(n>0)
        {
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
    public int minElement(int[] nums) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            ans=Math.min(ans,func(nums[i]));
        }
        return ans;
    }
}