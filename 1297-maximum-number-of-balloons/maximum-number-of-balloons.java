class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<text.length();i++)
        {
            char c=text.charAt(i);
            if(c=='l' || c=='b' || c=='a' || c=='o' || c=='n')
            {
                if(map.containsKey(c))map.put(c,map.get(c)+1);
                else map.put(c,1);
            }
        }
        if(map.size()<5)return 0;
        for(char c:map.keySet())
        {
            System.out.printf("%c->%d , ",c,map.get(c));
        }
        int mini=Integer.MAX_VALUE;
        for(char c:map.keySet())
        {
            int count=0;
            if(c=='l' || c=='o')count=map.get(c)/2;
            else count=map.get(c);
            mini=Math.min(mini,count);
        }
        if(mini==Integer.MAX_VALUE)return 0;
        else return mini;

    }
}