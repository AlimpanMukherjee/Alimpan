class Solution {
    public int maxDepth(String s) {
        //List<Integer> lst=new ArrayList<>();
        int count=0;
        Stack<Character> st=new Stack<>();
        //int start=0;
        int maxi=0;
        // while(start<s.length() && s.charAt(start)!='(')
        // {
        //     start++;
        // }
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {        
                count++;
                //lst.add(count);                
                st.push('(');
            }
            else if(s.charAt(i)==')')
            {
                //lst.add(count);
                count--;
                st.pop();
            }
            maxi=Math.max(maxi,count);
        }
        return maxi;
    }
}