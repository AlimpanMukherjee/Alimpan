class Pair{
    int num,count;
    Pair(int num,int count)
    {
        this.num=num;
        this.count=count;
    }
}
class Solution {
    public int minimumPushes(String word) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<word.length();i++)
        {
            if(!map.containsKey(word.charAt(i)))map.put(word.charAt(i),1);
            else map.put(word.charAt(i),map.get(word.charAt(i))+1);
        }
        int count=0;
        int total=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.count-a.count);
        for(char c:map.keySet())
        {
            Pair p=new Pair(c,map.get(c));
            pq.offer(p);
        }
        while(!pq.isEmpty())
        {
            count++;
            int num=pq.poll().count;
            if(count<=8)total+=(1*num);
            else if(count<=16)total+=(2*num);
            else if(count<=24)total+=(3*num);
            else total+=(4*num);
        }
        return total;
    }
}