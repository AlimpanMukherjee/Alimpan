
class Solution {
    public void func(int [][]isConnected,int []visited,int i)
    {
        
        int n=isConnected.length;
        Queue<Integer> q=new LinkedList<>();
        q.offer(i);
        visited[i]=1;
        while(!q.isEmpty())
        {
            int num=q.poll();
            for(int k=0;k<n;k++)
            {
                
                if(visited[k]==0 && isConnected[num][k]==1)
                {
                    visited[k]=1;
                    q.offer(k);
                }

            }
        }
        return;
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int visited[]=new int[n];
        int count=0;

        for(int i=0;i<n;i++)
        {
            
            if(visited[i]==0 )
            {
                count++;
                func(isConnected,visited,i);
            }      
                    
        } 
        return count;  
    }
}