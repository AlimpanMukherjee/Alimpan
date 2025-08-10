class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxcount=0;
        int count=0;
        int l=0;
        int r=0;
        int zero=0;

        while(r<nums.length)
        {
            if(nums[r]==0)zero++;
            if(zero>k)
            {
                if(nums[l]==0)zero--;
                l=l+1;
            }
            if(zero<=k)
            {
                maxcount=Math.max(maxcount,r-l+1);
            }
            r++;
        }
        
        return maxcount;
    }
    
}