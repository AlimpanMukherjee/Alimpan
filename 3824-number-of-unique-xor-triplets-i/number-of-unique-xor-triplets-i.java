class Solution {
    public int uniqueXorTriplets(int[] nums) {
        if(nums.length==1)return 1;
        if(nums.length==2)return 2;
        int i=0;
        while(true)
        {
            if(Math.pow(2,i)>nums.length)return (int)Math.pow(2,i);
            i++;
        }
    }
}