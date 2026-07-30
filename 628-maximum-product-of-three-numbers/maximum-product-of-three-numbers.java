class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int a=nums[0]*nums[1];
        int b=nums[nums.length-2]*nums[nums.length-3];
        return Math.max(nums[nums.length-1]*a,nums[nums.length-1]*b);
    }
}