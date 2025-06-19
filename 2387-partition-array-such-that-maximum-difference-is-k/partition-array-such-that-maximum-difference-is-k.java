class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int least=nums[0];
        int count=1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]-least>k)
            {
                count++;
                least=nums[i];
            }
        }
        return count;
    }
}