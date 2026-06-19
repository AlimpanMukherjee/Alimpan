class Solution {
    public String minWindow(String s, String t) {
        String ans="";
        int l=0;
        int r=0;
        Map<Character,Integer> map=new HashMap<>();
        Map<Character,Integer> req=new HashMap<>();
        int count=0;
        for(int i=0;i<t.length();i++)
        {
            if(req.containsKey(t.charAt(i)))req.put(t.charAt(i),req.get(t.charAt(i))+1);
            else req.put(t.charAt(i),1);
        }
        int minlen=Integer.MAX_VALUE;
        while(r<s.length())
        {
            if(req.containsKey(s.charAt(r)))
            {
                if(map.containsKey(s.charAt(r)))
                {
                    map.put(s.charAt(r),map.get(s.charAt(r))+1);
                }
                else map.put(s.charAt(r),1);
                if(req.get(s.charAt(r)).equals(map.get(s.charAt(r))))count++;


                while(count==req.size())
                {
                    //while(count==req.size())
                    if(r-l+1<minlen)
                    {
                        minlen=r-l+1;
                        ans=s.substring(l,r+1);
                        
                    }
            
                    if(map.containsKey(s.charAt(l)))
                    {
                        map.put(s.charAt(l),map.get(s.charAt(l))-1);
                        if(map.get(s.charAt(l))<req.get(s.charAt(l)))
                        {
                            count--;
                            l++;
                            break;
                        }
                    } 
                    l++;

                }  
            }
            r++;
        }
        return ans;
    }
}
