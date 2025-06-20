class Solution {
    public int countOnes(String s)
    {
        int count=0;
        int i=0;
        while(i<s.length())
        {
            if(s.charAt(i) == '1')
            count++;
            i++;
        }
        return count;
    }
    public int numberOfBeams(String[] bank) {
        int total=0;
        int prev=0;
       for(String s:bank)
       {
            int count=countOnes(s);
            total+=(count*prev);
            if(count!=0)
            {
                prev=count;
            }

       } 
       return total;
    }
}