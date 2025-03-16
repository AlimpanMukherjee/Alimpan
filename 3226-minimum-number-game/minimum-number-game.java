class Solution {
    public int[] numberGame(int[] nums) {

        Arrays.sort(nums); 
        int i;
        int a[]=new int[nums.length];
        for(i=0;i<nums.length;i+=2)
        {
            a[i+1]=nums[i];
        } 
        for(i=1;i<nums.length;i+=2)
        {
            a[i-1]=nums[i];
        }
        return a;          
    }
}