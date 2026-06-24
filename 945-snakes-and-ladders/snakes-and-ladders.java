class Pair{
    int val,count;
    Pair(int val,int count)
    {
        this.val=val;
        this.count=count;
    }
}
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=n-1;i>=0;i--)
        {   int rowbottom=n-i-1;

            for(int j=0;j<n;j++)
            {
                if(rowbottom%2==0 && board[i][j]!=-1)
                {
                    int start=n*(n-i-1);
                    start+=j+1;
                    map.put(start,board[i][j]);
                }
                else if(board[i][j]!=-1)
                {
                    int start=n*(n-i-1);
                    start+=n-j;
                    map.put(start,board[i][j]);
                }
            }              
        }
        // for(int i=n-1;i>=0;i--)
        // {
        //     int rowFromBottom = n - 1 - i;

        //     for(int j=0;j<n;j++)
        //     {
        //         if(board[i][j] == -1) continue;

        //         int start;

        //         if(rowFromBottom % 2 == 0)
        //             start = rowFromBottom * n + j + 1;
        //         else
        //             start = rowFromBottom * n + (n - j);

        //         map.put(start, board[i][j]);
        //     }
        // }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.count-b.count);
        pq.offer(new Pair(1,0));
        int ans=-1;
        int visited[]=new int[(n*n)+1];
        visited[1]=1;
        
        while(!pq.isEmpty())
        {
            int curr=pq.peek().val;
            int count=pq.peek().count;
            pq.poll();
            
            for(int i=1;i<=6;i++)
            {
                int newval=curr+i;
                if(newval>n*n)continue;
                if(map.containsKey(newval))newval=map.get(newval);
                if(newval==n*n)return count+1;
                if(visited[newval]==1)continue;
                pq.offer(new Pair(newval,count+1));
                visited[newval]=1;
            }
        }
         return -1;

    }
}