class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        String strs2[]=new String[strs.length];
        for(int i=0;i<strs.length;i++)
        {
            char c[]=strs[i].toCharArray();
            Arrays.sort(c);
            strs2[i]=new String(c);
        }
        for(int i=0;i<strs.length;i++)
        {
            if(map.containsKey(strs2[i]))
            {
                map.get(strs2[i]).add(strs[i]);
            }
            else
            {
                map.put(strs2[i],new ArrayList<>());
                map.get(strs2[i]).add(strs[i]);
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(String lst: map.keySet())
        {
            ans.add(map.get(lst));
        }
        return ans;
    }
}