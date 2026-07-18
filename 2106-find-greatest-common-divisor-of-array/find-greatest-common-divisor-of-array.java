class Solution {
    int func(int a,int b)
    {
        if(b!=0)
        {
            return func(b,a%b);
        }
        return a;
    }
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return func(nums[0],nums[nums.length-1]);
    }
}