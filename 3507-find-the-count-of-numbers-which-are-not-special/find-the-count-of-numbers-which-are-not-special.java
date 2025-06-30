class Solution {
   
    public int nonSpecialCount(int l, int r) {
        int count=0;
        int upper=(int)Math.sqrt(r);
        int []prime=new int[upper+1];
        Arrays.fill(prime,1);
        prime[0]=0;
        prime[1]=0;
        for(int i=2;i*i<=upper;i++)
        {
            if(prime[i]==1)
            {
                for(int j=i*i;j<=upper;j+=i)
                {
                    prime[j]=0;
                }
            }
        }
        // for(int i=l;i<=r;i++)
        // {
        //     int b=(int)Math.sqrt(i);
        //     if( b*b ==i && prime[b]==1)continue;
        //     else count++;
        // }
        int n=0;
        int lower=(int)Math.sqrt(l);
        if(lower*lower!=l)lower+=1;
        for(int i=lower;i<=upper;i++)
        {
            if(prime[i]==1)n++;
        }
        count=(r-l+1)-n;
        return count;
    }
}