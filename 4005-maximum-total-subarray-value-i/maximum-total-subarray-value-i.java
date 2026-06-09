class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long mini=Integer.MAX_VALUE;
        long maxi=Integer.MIN_VALUE;
        long sum=0;
        for(int i=0;i<nums.length;i++)
        {
            mini=Math.min(mini,nums[i]);
            maxi=Math.max(maxi,nums[i]);
        }
        return k*(maxi-mini);
    }
}