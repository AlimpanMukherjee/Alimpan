class Solution {
    public void generate(int index,List<Integer> ls,List<List<Integer>> ans,int []nums,HashSet<List<Integer>> set)
    {
        if(index==nums.length)
        {
            if(set.contains(ls))return;
            set.add(ls);
            ans.add(new ArrayList<>(ls));
            return ;
        }
        ls.add(nums[index]);
        generate(index+1,ls,ans,nums,set);
        ls.remove(ls.size()-1);
        generate(index+1,ls,ans,nums,set);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List <Integer> ls=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        HashSet<List<Integer>> set=new HashSet<>();
        Arrays.sort(nums);
        generate(0,ls,ans,nums,set);
        return ans;
    }
}