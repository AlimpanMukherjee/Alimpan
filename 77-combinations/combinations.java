class Solution {
    public void generate(int i,int n,int k,List<Integer> ls,List<List<Integer>> ans)
    {
        if(ls.size()==k)
        {
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(i<=n)
        {
            ls.add(i);
            generate(i+1,n,k,ls,ans);
            ls.remove(ls.size()-1);
            generate(i+1,n,k,ls,ans);
        }

    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> ls=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        generate(1,n,k,ls,ans);
        return ans;
    }
}