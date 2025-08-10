class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int l=0;
        int r=0;
        int maxlen=0;
        int maxfreq=0;
        HashMap<Character,Integer> map=new HashMap<>();
        
        while(r<s.length())
        {
            if(map.containsKey(s.charAt(r))) map.put(s.charAt(r),map.get(s.charAt(r))+1);
            else map.put(s.charAt(r),1);
            maxfreq=Math.max(maxfreq,map.get(s.charAt(r)));
            
            while((r-l+1)-maxfreq>k)
            {
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                maxfreq=0;
                for(char c:map.keySet())
                {
                    maxfreq=Math.max(maxfreq,map.get(c));
                }
                l+=1;
            }
            if(r-l+1-maxfreq<=k)maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}