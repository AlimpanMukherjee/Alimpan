class Solution {
    public boolean isPrime(int n)
    {
        
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)return false;
        }
        return true;
    }
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans=new ArrayList<>();
        int low=2;
        int high=n;
        while(low<=high)
        {
            if (low+high==n) 
            {
                if(isPrime(low) && isPrime(high))
                {
                    List <Integer> dummy=new ArrayList<>();
                    dummy.add(low);
                    dummy.add(high);
                    ans.add(dummy);
                }
                low++;
                high--;
            }
            else if(low+high < n)
            {
                low+=1;
            }
            else
            {
                high=high-1;
            }
        }
        return ans;
    }
}