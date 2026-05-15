class Solution {

    public boolean dfs2(int numCourses,
                        Map<Integer, List<Integer>> map,
                        int i,
                        int[] visited,
                        int[] pathvisited) {

        visited[i] = 1;
        pathvisited[i] = 1;

        if (map.containsKey(i)) {

            for (int j : map.get(i)) {

                if (visited[j] == 0) {

                    if (dfs2(numCourses, map, j, visited, pathvisited))
                        return true;
                }

                else if (visited[j] == 1 && pathvisited[j] == 1)
                    return true;
            }
        }

        pathvisited[i] = 0;

        return false;
    }

    public boolean check(int numCourses,
                         Map<Integer, List<Integer>> map) {

        int visited[] = new int[numCourses];
        int pathvisited[] = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {

            if (visited[i] == 0) {

                if (dfs2(numCourses, map, i, visited, pathvisited))
                    return true;
            }
        }

        return false;
    }

    public void dfs(int i,
                    Map<Integer, List<Integer>> map,
                    int visited[],
                    Stack<Integer> st) {

        if (map.containsKey(i)) {

            for (int j : map.get(i)) {

                if (visited[j] == 0) {

                    visited[j] = 1;

                    dfs(j, map, visited, st);
                }
            }
        }

        st.push(i);
    }

    public int[] findOrder(int numCourses, int[][] pre) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        int n = pre.length;

        for (int i = 0; i < n; i++) {

            int parent = pre[i][1];
            int child = pre[i][0];

            if (map.containsKey(parent)) {

                map.get(parent).add(child);

            } else {

                map.put(parent, new ArrayList<>());
                map.get(parent).add(child);
            }
        }

        if (check(numCourses, map) == true)
            return new int[0];

        Stack<Integer> st = new Stack<>();

        int visited[] = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {

            if (visited[i] == 0) {

                visited[i] = 1;

                dfs(i, map, visited, st);
            }
        }

        int k = 0;

        int[] ans = new int[numCourses];

        while (!st.isEmpty()) {

            ans[k] = st.pop();

            k++;
        }

        return ans;
    }
}