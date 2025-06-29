class Solution {
    public int smallestValue(int n) {
        int sum=0;
        int original=n;
        if(n==1)return 1;
        for(int i=2;i*i<=(n);i++)
        {
            if(n%i==0)
            {
                while(n%i==0)
                {
                    sum+=i;
                    n=n/i;
                }
            }
        }
        if(n!=1)sum+=n;
        if(sum==original)return sum;
        else return smallestValue(sum);
    }
}