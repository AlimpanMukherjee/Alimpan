class Solution {
    public int findprime(int n)
    {
        int largestprime=1;
        for(int i=1;i<n/2;i++)
        {
            if(n%i==0)
            {
                largestprime=i;
            }
        }
        return largestprime;
    }


    public int minSteps(int n) {
    Solution a=new Solution();
    if(n==1)
    {
        return 0;
    }        
    if(n%2!=0)
    {
        int k=a.findprime(n);
        int add=n/k;
        return a.minSteps(k)+add;
    }
    else
    {
        return 2+minSteps(n/2);
    }
    
    }
}