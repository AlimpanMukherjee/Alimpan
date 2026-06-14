class Solution {
    public long maxRatings(int[][] units) {
        long sum=0;
        int n=units.length;
        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;
        long ans=0;
        int idx=0;
        for(int i=0;i<n;i++)
            {
                Arrays.sort(units[i]);
            }
        for(int i=0;i<n;i++)
            {
                if(units[i].length>1)sum+=units[i][1];
                else sum+=units[i][0];
                if(units[i].length>1)second=Math.min(second,units[i][1]);
                else second=Math.min(second,units[i][0]);
                first=Math.min(first,units[i][0]);
                
                
            }
        
        ans=sum-second+first;
        return ans;
    }
}