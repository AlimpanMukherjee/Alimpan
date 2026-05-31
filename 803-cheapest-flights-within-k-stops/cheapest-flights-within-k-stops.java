class Pair{
    int x,price;
    Pair(int x,int price)
    {
        this.x=x;
        this.price=price;
    }
}
class Tuple{
    int x,price,k;
    Tuple(int price,int x,int k)
    {
        this.x=x;
        this.price=price;
        this.k=k;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++)
        {
            int u=flights[i][0];
            int v=flights[i][1];
            int dist=flights[i][2];
            adj.get(u).add(new Pair(v,dist));
        }
        int cost[]=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->a.k-b.k);
        pq.offer(new Tuple(0,src,0));
        cost[src]=0;  
        while(!pq.isEmpty())
        {
            // Pair p=pq.poll();
            int num=pq.peek().x;
            int price=pq.peek().price;
            int steps=pq.peek().k;
            pq.poll();
            if(steps>k)continue;
            steps++;
            //if(adj.get(num)==null)continue;
            for(Pair p:adj.get(num))
            {
                if(cost[p.x]>price+p.price)
                {
                    cost[p.x]=price+p.price;
                    if(p.x==dst)continue;
                    pq.offer(new Tuple(cost[p.x],p.x,steps));
                }
            }
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }
}