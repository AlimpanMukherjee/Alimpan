class Solution {
    public String smallestPalindrome(String s) {
        List<Character> lst=new ArrayList<>();
        for(int i=0;i<(s.length()/2);i++)
        {
            lst.add(s.charAt(i));
        }
        Collections.sort(lst);
        StringBuilder st=new StringBuilder();
        for(char c:lst)
        {
            st.append(c);
        }
        if(s.length()%2!=0)
        {
            st.append(s.charAt((s.length()/2)));
        }
        for(int i=lst.size()-1;i>=0;i--)
        {
            st.append(lst.get(i));
        }
        return st.toString();
    }
}