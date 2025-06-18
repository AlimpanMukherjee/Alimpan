class Solution {
    public int reachNumber(int target) {
        int sum=0;
        int i=1;
        target=Math.abs(target);
        while(true)
        {
            sum+=i;
            if(sum==target)
            {
                return i;
            }
            while(sum>target)
            {
                while((sum-target)%2!=0)
                {
                    i++;
                    sum+=i;
                }
                return i;
            }
            i++;
        }
    }
}