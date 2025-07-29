class Solution {
    public void generate(int index,List<Integer> ls,List<List<Integer>> ans,int []nums)
    {
        if(index==nums.length)
        {
            ans.add(new ArrayList<>(ls));
            return ;
        }
        ls.add(nums[index]);
        generate(index+1,ls,ans,nums);
        ls.remove(ls.size()-1);
        generate(index+1,ls,ans,nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List <Integer> ls=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        generate(0,ls,ans,nums);
        return ans;
    }
}