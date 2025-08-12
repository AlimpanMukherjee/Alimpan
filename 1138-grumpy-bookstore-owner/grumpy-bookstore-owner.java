class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int total=0;
        int l=0;
        int r=0;
        int count=0;
        int maxvalue=0;
        for(int i=0;i<customers.length;i++)
        {
            if(grumpy[i]==0)
            {
                count+=customers[i];
            }
        }
        while(r<customers.length)
        {
            if(r-l+1<=minutes)
            {
                if(grumpy[r]==1)
                {
                    total+=customers[r];
                }
            }
            if(r-l+1==minutes)
            {
                maxvalue=Math.max(total,maxvalue);
            }
            if(r-l+1>minutes)
            {
                if(grumpy[l]==1)total-=customers[l];
                l++;
                if(grumpy[r]==1)total+=customers[r];
                maxvalue=Math.max(maxvalue,total);
            }
            r++;
        }

        return maxvalue+count;
    }
}