class Solution {
    Boolean isPossible(int mid,int [][] tasks)
    {
        for(int i=0;i<tasks.length;i++)
        {
            if(mid<tasks[i][1])return false;
            int diff=tasks[i][1]-tasks[i][0];
            mid-=tasks[i][0];
        }
        return true;
    }
    public int minimumEffort(int[][] tasks) {
        int n=tasks.length;
        Arrays.sort(tasks,(task1,task2)->{
            int diff1=task1[1]-task1[0];
            int diff2=task2[1]-task2[0];
            return diff2-diff1;
        });
        int left=0;
        int right=Integer.MAX_VALUE;
        int ans=0;
        for(int i = 0; i < n; i++) {
    System.out.printf("%d, %d\n", tasks[i][0], tasks[i][1]);
}
        while(left<=right)
        {
            int mid=(left+right)/2;
            if(isPossible(mid,tasks))
            {
                ans=mid;
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return ans;
    }
}