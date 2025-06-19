class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List <Integer> less=new ArrayList<>();
        List <Integer> eql=new ArrayList<>();
        List <Integer> great=new ArrayList<>();
        for(int num:nums)
        {
            if(num==pivot)eql.add(num);
            else if(num<pivot)less.add(num);
            else great.add(num);
        }
        int i=0;
        for(int num:less)
        {
            nums[i++]=num;
        }
        for(int num:eql)
        {
            nums[i++]=num;
        }
        for(int num:great)
        {
            nums[i++]=num;
        }
        return nums;
    }
}