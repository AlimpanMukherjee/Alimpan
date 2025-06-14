class Solution {
    public boolean check(int[] piles,int n,int mid,int h)
    {
        int totaltime=0;
        for(int i=0;i<n;i++)
        {
            totaltime+=Math.ceil((double)piles[i] / mid);
        }
        if(totaltime<=h)return true;
        else return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high=Arrays.stream(piles).max().getAsInt();
        int ans=high;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(check(piles,piles.length,mid,h))
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}