class Solution {
    public int pivotInteger(int n) {
        int sum=n*(n+1)/4;
        int k=0,l=0;
        int i=0;
        if(n==1)
        {
            return 1;
        }
        while(k+i<=sum)
        {
            k=k+i;
            i++;
        }
        for(int j=i;j<=n;j++)
        {
            l=l+j;
        }
        if(k+i==l)
        {
            return i;
        }
        else
        {
            return -1;
        }
    }
}