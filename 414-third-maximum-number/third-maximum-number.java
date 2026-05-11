class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        List <Integer> ans=new ArrayList<>();
        ans.add(nums[0]);
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]!=nums[i-1])ans.add(nums[i]);
        }
        if(ans.size()<3)return ans.get(ans.size()-1);
        return ans.get(ans.size()-3);
    }
}