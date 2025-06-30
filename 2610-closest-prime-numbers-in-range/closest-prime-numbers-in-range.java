class Solution {
    public int[] closestPrimes(int left, int right) {
        int prime[]=new int[right+1];
        Arrays.fill(prime,1);
        prime[0]=0;
        prime[1]=0;
        for(int i=2;i*i<=right;i++)
        {
            if(prime[i]==1)
            {
                for(int j=i*i;j<=right;j+=i)
                {
                    prime[j]=0;
                }
            }
        }
        int first=-1;
        int second=-1;
        int diff=Integer.MAX_VALUE;

        int []a=new int[2];
        a[0]=-1;
        a[1]=-1;

        for(int i=left;i<=right;i++)
        {
            if(prime[i]==1)
            {
                second=first;
                first=i;
                if(first!=-1 && second!=-1){
                    if(diff>first-second)
                    {
                        diff=first-second;
                        a[0]=second;
                        a[1]=first;
                    }
                }
            }
        }
        return a;
    }
}