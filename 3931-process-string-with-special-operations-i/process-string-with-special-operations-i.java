class Solution {
    public String processStr(String s) {
        StringBuilder st=new StringBuilder();
        int n=s.length();
        int j=0;
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(c=='*' && st.length()>0)st.deleteCharAt(st.length()-1);
            else if(c=='#' && st.length()>0)
            {
                StringBuilder dummy=st;
                st.append(dummy);
            }
            else if(c=='%' && st.length()>0)
            {
                st.reverse();
            }
            else if(c!='*' && c!='#' && c!='%')st.append(c);

        }
        return st.toString();
    }
}