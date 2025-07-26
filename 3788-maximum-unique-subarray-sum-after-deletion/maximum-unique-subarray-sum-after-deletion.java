class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); 
        List<Integer> list=new ArrayList<>();
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            if(set.contains(nums[i]))continue;
            else if(nums[i]>0) 
            {
                set.add(nums[i]);
                sum+=nums[i];
            }
        }
        if(set.size()==0)
        {
            int max=Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++)
            {
                max=Math.max(max,nums[i]);
            }
            return max;
        }
        return sum; 
    }
}
