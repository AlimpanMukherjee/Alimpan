class Solution {

    public boolean check(int [][]graph,int []visited,int []pathvisited,int i)
    {
        

        pathvisited[i]=1;

        for(int j=0;j<graph[i].length;j++)
        {
            int node=graph[i][j];

            if(visited[node]==0)
            {
                visited[i]=1;
                if(check(graph,visited,pathvisited,node))return true;
            }
            else
            {
                if(pathvisited[node]==1)return true;
            }
        }

        pathvisited[i]=0;

        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n=graph.length;

        int visited[]=new int[n];

        int pathvisited[]=new int[n];

        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)check(graph,visited,pathvisited,i);
        }

        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            visited[i]=1;
            if(pathvisited[i]==0)ans.add(i);
        }

        return ans;
    }
}