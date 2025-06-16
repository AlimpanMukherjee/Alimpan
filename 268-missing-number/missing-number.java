class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int low=0;
        if(nums[0]!=0) return 0;
        if(nums[nums.length-1]==nums.length-1)return nums.length;
        int high=Arrays.stream(nums).max().getAsInt();
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(nums[mid]==mid)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return low;
    }
}