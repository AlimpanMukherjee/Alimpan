class Solution {
    public boolean increasingTriplet(int[] nums) {
    //     
    int second=Integer.MAX_VALUE;
    int first=Integer.MAX_VALUE;
    for(int num:nums)
    {
        if(num<first)
        {
            first=num;
        }
        else if(num<second && num>first)
        {
            second=num;
        }
        else if(num>second)
        {
            return true;
        }
    }
    return false;
    }
}