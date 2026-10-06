class Solution {
    public int minAddToMakeValid(String s) {
        int open=0;
        int close=0;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(' )   st.push('(');
            else if(s.charAt(i)==')' && !st.isEmpty() && st.peek()=='(')st.pop();
            else if(s.charAt(i)==')')st.push(')');            
        }
        return st.size();
    }
}