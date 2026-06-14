class Solution {
    public String intToRoman(int num) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
        map.put(4,"IV");
        map.put(9,"IX");
        map.put(40,"XL");
        map.put(90,"XC");
        map.put(400,"CD");
        map.put(900,"CM");
        StringBuilder ans=new StringBuilder();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i:map.keySet())pq.offer(i);
        // pq.offer(1);
        // pq.offer(5);
        // pq.offer(10);
        // pq.offer(50);
        // pq.offer(100);
        // pq.offer(500);
        // pq.offer(1000);
        // pq.offer(4);
        // pq.offer(9);
        // pq.offer(40);
        // pq.offer(90);
        // pq.offer(400);
        // pq.offer(900);
        while(num>0)
        {
            int n=pq.poll();
            if(num/n>=1)
            {
                int x=num/n;
                num=num-x*n;
                for(int i=0;i<x;i++)ans.append(map.get(n));
            }
        }
        return ans.toString();

    }
}