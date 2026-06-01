class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int count=0;
        int sum=0;
        for(int i=cost.length-1;i>=0;i--)
        {
            count++;
            if(count==3)
            {
                count=0;
                continue;
            }
            sum+=cost[i];
        }
        // int dist=(cost.length/3)*3;
        // int sum=0;
        // for(int i=0;i<dist;i++)
        // {
        //     if(i%3==0)continue;
        //     sum+=cost[i];
        // }
        // for(int i=dist;i<cost.length;i++)
        // {
        //     sum+=cost[i];
        // }

        return sum;
    }
}