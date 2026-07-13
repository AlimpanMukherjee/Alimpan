class Solution {
    void func(int i,int j,List<Integer> ans,int low,int high)
    {
        if(j==9)return;
        int num=i*10+(1+j);
        if(num>high)return ;
        if(num>=low && num<=high)ans.add(num);
        if(j==9)return;
        func(num,j+1,ans,low,high);

    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<9;i++)
        {
            func(i,i,ans,low,high);
        }
        Collections.sort(ans);
        return ans;
    }
}