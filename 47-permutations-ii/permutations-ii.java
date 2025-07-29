class Solution {
    public void generate(List<Integer> ls,List<List<Integer>> ans,int []nums,HashSet<List<Integer>> set,int []freq)
    {
        if(ls.size()==nums.length)
        {
            if(set.contains(ls)) return;
            else 
            {
                set.add(ls);
                ans.add(new ArrayList<>(ls));
                return;
            }  
        }
        for(int i=0;i<nums.length;i++)
        {
            if(freq[i]==1)
            {
                freq[i]=0;
                ls.add(nums[i]);
                generate(ls,ans,nums,set,freq);
                ls.remove(ls.size()-1);
                freq[i]=1;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> ls=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        HashSet<List<Integer>> set=new HashSet<>();
        int []freq=new int[nums.length];
        Arrays.fill(freq,1);

        generate(ls,ans,nums,set,freq);
        return ans;

    }
}