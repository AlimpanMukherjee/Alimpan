class Pair{
    int x,wt;

    Pair(int x,int wt)
    {
        this.x=x;
        this.wt=wt;
    } 
}

class Solution {

int func(List<List<Pair>> adj,int i,int dist)
{
    PriorityQueue<Pair> pq=
        new PriorityQueue<>((a,b)->a.wt-b.wt);

    int cost[]=new int[adj.size()];
    Arrays.fill(cost,Integer.MAX_VALUE);

    cost[i]=0;

    pq.offer(new Pair(i,0));

    while(!pq.isEmpty())
    {
        Pair p=pq.poll();

        int x=p.x;
        int d=p.wt;

        if(d>cost[x])continue;

        for(Pair p1:adj.get(x))
        {
            if(d+p1.wt<cost[p1.x])
            {
                cost[p1.x]=d+p1.wt;

                pq.offer(new Pair(p1.x,cost[p1.x]));
            }
        }
    }

    int count=0;

    for(int j=0;j<adj.size();j++)
    {
        if(j!=i && cost[j]<=dist)
        {
            count++;
        }
    }

    return count;
}
    public int findTheCity(int n, int[][] edges, int dist) {

        List<List<Pair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];

            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }

        int count[]=new int[n];

        int mini=Integer.MAX_VALUE;
        int idx=-1;

        for(int i=0;i<n;i++)
        {
            count[i]=func(adj,i,dist);
            System.out.println(count[i]);

            if(count[i]<=mini)
            {
                mini=count[i];
                idx=i;
            }
        }

        return idx;
    }
}