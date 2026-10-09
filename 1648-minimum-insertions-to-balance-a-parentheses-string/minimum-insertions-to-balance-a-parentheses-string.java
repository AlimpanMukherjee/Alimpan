class Solution {
    public int minInsertions(String s) {
        Stack<Character> st=new Stack<>();
        int count=0;
        int req=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='(')
            {
                st.push(c);
                //else                 
            }
            else if(c==')')
            {
                count++;
                if(st.isEmpty() || st.peek()!='(')
                {
                    //st.pop();                    
                    req++;
                }
                if(count==1 && i==s.length()-1)
                {
                    if(!st.isEmpty())st.pop();
                    req++;
                }
                else if(count==1 &&  s.charAt(i+1)=='(')
                {
                    req++;
                    count=0;
                    if(!st.isEmpty())st.pop();
                    //i++;
                }
                
                else if(count==1 && s.charAt(i+1)==')')
                {
                    i++;
                    count=0;
                    if(!st.isEmpty())st.pop();
                }
            }
        }
        if(!st.isEmpty())
        {
            req+=st.size()*2;
        }
        return req;
    }
}