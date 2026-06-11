import java.util.*;

class Solution {
    private long powerMod(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp % 2) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }

    public int assignEdgeWeights(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = 0;
        for (int i = 0; i < edges.length; i++) {
            n = Math.max(Math.max(n, edges[i][0]), edges[i][1]);
        }
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            if(map.containsKey(v))map.put(v,map.get(v)+1);
            else map.put(v,1);
            if(!map.containsKey(u))map.put(u,0);
        }
        int start=-1;
        for(int i:map.keySet())
        {
            if(map.get(i)==0)start=i;
        }
        int level = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                int num = q.poll();
                
                for (int v : adj.get(num)) {
                    q.offer(v);
                }
            }
        }
        
        System.out.println(level);
        
        if (level < 1) return 0;
        
        long MOD = (long) 1e9 + 7;
        long ans = powerMod(2, level - 2, MOD);
        
        return (int) ans;               
    }
}