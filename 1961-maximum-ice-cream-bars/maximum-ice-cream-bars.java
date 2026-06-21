class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxi=-1;
        int count=0;
        for(int i=0;i<costs.length;i++)
        {
            maxi=Math.max(maxi,costs[i]);
        }
        int a[]=new int[maxi+1];
        for(int i=0;i<costs.length;i++)
        {
            a[costs[i]]+=1;
        }
        for(int i=1;i<=maxi;i++)
        {
            if(a[i]==0)continue;
            if(coins>=i)
            {

                int x=coins/i;
                x=Math.min(x,a[i]);
                count+=x;
                coins-=x*i;                
            }
        }
        return count;
    }
}