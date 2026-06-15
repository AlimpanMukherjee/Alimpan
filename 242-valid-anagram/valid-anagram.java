class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();
        if(s.length()!=t.length())return false;
        int n=s.length();

        for(int i=0;i<n;i++)
        {
            if(map.containsKey(s.charAt(i)))map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else map.put(s.charAt(i),1);
        }
        for(int i=0;i<n;i++)
        {
            char k=t.charAt(i);
            if(!map.containsKey(k))return false;
            else
            {
                map.put(k,map.get(k)-1);
                if(map.get(k)==0)map.remove(k);
            }

        }
        if(map.size()==0)return true;
        return false;

    }
}