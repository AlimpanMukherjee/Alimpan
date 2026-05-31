class Pair{
    int x;
    long dist;

    Pair(int x,long dist)
    {
        this.x=x;
        this.dist=dist;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {

        List<List<Pair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<roads.length;i++)
        {
            int u=roads[i][0];
            int v=roads[i][1];
            int dist=roads[i][2];

            adj.get(u).add(new Pair(v,dist));
            adj.get(v).add(new Pair(u,dist));
        }

        long cost[]=new long[n];
        Arrays.fill(cost,Long.MAX_VALUE);

        long distance[]=new long[n];
        distance[0]=1;

        int mod=(int)(1e9+7);

        PriorityQueue<Pair> pq=
            new PriorityQueue<>((a,b)->Long.compare(a.dist,b.dist));

        pq.offer(new Pair(0,0));

        cost[0]=0;

        while(!pq.isEmpty())
        {
            int num=pq.peek().x;
            long dist=pq.peek().dist;
            pq.poll();

            if(dist>cost[num])continue;

            for(Pair p:adj.get(num))
            {
                long newDist=p.dist+dist;

                if(newDist==cost[p.x])
                {
                    distance[p.x]=(distance[p.x]+distance[num])%mod;
                }
                else if(newDist<cost[p.x])
                {
                    distance[p.x]=distance[num];

                    cost[p.x]=newDist;

                    pq.offer(new Pair(p.x,cost[p.x]));
                }
            }
        }

        return (int)(distance[n-1]%mod);
    }
}