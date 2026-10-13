class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        int n=nums.length;
        if(n==1)return nums[0];
        long sum1=0;
        long sum2=0;

        for(int i=0;i<n/2;i++)
        {
            sum1+=nums[i];
        }
        for(int i=n/2;i<n;i++)
        {
            sum2+=nums[i];
        }
        return sum2-sum1;
    }
}