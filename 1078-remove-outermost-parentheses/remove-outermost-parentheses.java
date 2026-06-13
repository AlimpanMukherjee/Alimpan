class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        st.push('(');
        StringBuilder ans=new StringBuilder();
        //int i=1;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                if(st.size()>0)ans.append(s.charAt(i));
                st.push(s.charAt(i));
            }
            else
            {
                if(st.size()>1)ans.append(s.charAt(i));
                st.pop();
            }
            //i++;
        }
        return ans.toString();
    }
}