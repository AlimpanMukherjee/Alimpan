
class Pair {
    int num, dist;

    Pair(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }
}

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int maxi = 0;
        if (source == target)
            return 0;
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                maxi = Math.max(routes[i][j], maxi);
                if (map.containsKey(routes[i][j]))
                    map.get(routes[i][j]).add(i);
                else {
                    map.put(routes[i][j], new HashSet<>());
                    map.get(routes[i][j]).add(i);
                }
            }
        }
        if(maxi<source || maxi<target)return -1;
        int visited[] = new int[maxi + 1];
        visited[source] = 1;
        int busvisited[]=new int[routes.length];

        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(source, 0));
        while (!pq.isEmpty()) {
            int size = pq.size();
            
            for (int x = 0; x < size; x++) {
                int currstop = pq.peek().num;
                int bus = pq.peek().dist;
                pq.poll();
                if (!map.containsKey(currstop))
                    continue;
                Set<Integer> s = map.get(currstop);
                if (s.size() == 0)
                    continue;
                for (int busno : s) {
                    if(busvisited[busno]==1)continue;
                    busvisited[busno]=1;
                    for (int stop : routes[busno]) {
                        if (stop == target)
                            return bus + 1;
                        if (visited[stop] == 0) {
                            visited[stop] = 1;
                            pq.offer(new Pair(stop, bus + 1));
                        }
                    }

                }
            }

        }
        return -1;

    }
}