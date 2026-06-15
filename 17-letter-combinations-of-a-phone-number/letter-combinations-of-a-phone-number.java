class Solution {
    public void generate(int idx,String digits,int n,List<String> ans,StringBuilder st)
    {
        if(idx==n)
        {
            ans.add(st.toString()); 
            return;
        }
        Map<Character,String> digitToLetters=new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        char num=digits.charAt(idx);
        for(int i=0;i<digitToLetters.get(num).length();i++)
        {
            st.append(digitToLetters.get(num).charAt(i));
            generate(idx+1,digits,n,ans,st);
            st.deleteCharAt(st.length()-1);
        }
        return ;
    }
    public List<String> letterCombinations(String digits) {
        int n=digits.length();
        List<String> ans=new ArrayList<>();
        StringBuilder st=new StringBuilder();
        generate(0,digits,n,ans,st);
        return ans;
    }
}