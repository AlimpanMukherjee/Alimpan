class Solution {
    public int numberOfSpecialChars(String s) {
        int count=0;
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)<97)
            {
                set1.add(s.charAt(i)-65);
            }
            else
            {
                set2.add(s.charAt(i)-97);
            }            
        }
        for(int i:set1)
        {
            if(set2.contains(i))count++;
        }
        return count;
    }
}