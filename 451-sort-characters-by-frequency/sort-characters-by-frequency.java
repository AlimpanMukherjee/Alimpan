class Pair
{
    char alpha;
    int count;
    Pair(char alpha,int count)
    {
        this.alpha=alpha;
        this.count=count;
    }

}
class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            else 
            {
                map.put(s.charAt(i),1);
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.count-a.count);
        for(char i:map.keySet())
        {
            pq.offer(new Pair(i,map.get(i)));
        }
        StringBuilder st=new StringBuilder();
        while(!pq.isEmpty())
        {
            char c=pq.peek().alpha;
            int freq=pq.peek().count;
            pq.poll();
            for(int i=0;i<freq;i++)
            {
                st.append(c);
            }
        }
        return st.toString();
    }
}