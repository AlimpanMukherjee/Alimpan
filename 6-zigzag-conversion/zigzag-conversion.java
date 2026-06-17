class Solution {
    public String convert(String s, int numRows) {
        int n=s.length();
        if(numRows==1)return s;
        List<List<Character>> lst=new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            lst.add(new ArrayList<>());
        }
        int j=0;
        boolean down=true;
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            lst.get(j).add(c);
            if(down)j++;
            else j--;
            if(j==numRows-1)down=false;
            if(j==0)down=true;
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<numRows;i++)
        {
            for(char c: lst.get(i))
            {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}