class Solution {

    public void func(int open,int closed,StringBuilder s,List<String> ans)
    {
        if(open==0 && closed==0)
        {
            String s1=s.toString();
            ans.add(s1);
            return;
        }

        if(open>0)
        {   
            int o=open;
            int c=closed;

            s.append('(');
            func(o-1,c,s,ans);
            s.deleteCharAt(s.length()-1);
        }

        if(open<closed)
        {
            int o=open;
            int c=closed;

            s.append(')');
            func(o,c-1,s,ans);        
            s.deleteCharAt(s.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {

        List<String> ans=new ArrayList<>();
        StringBuilder s=new StringBuilder();

        int open=n;
        int closed=n;

        func(open,closed,s,ans);

        return ans;
    }
}