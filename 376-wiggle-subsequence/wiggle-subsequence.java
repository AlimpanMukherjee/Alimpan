class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        if(n==1)return 1;
        if(n==2)
        {
            if(nums[0]==nums[1])return 1;
            return 2;
        }
        int []diff=new int[n];
        int count=0;
        int first=0;
        for(int i=0;i<n-1;i++)
        {
            diff[i+1]=nums[i+1]-nums[i];
        }
        for(int i=1;i<n;i++)
        {
            if(diff[i]==0)continue;
            else 
            {
                first=diff[i];
                break;
            }
        }

        if(first>=0)diff[0]=Integer.MIN_VALUE;
        else if(first<0)diff[0]=Integer.MAX_VALUE;
        int last=diff[0];
        for(int i=0;i<n-1;i++)
        {
            if(last>0 && diff[i+1]<0)count++;
            else if(last<0 && diff[i+1]>0)count++;
            if(diff[i+1]==0)continue;
            last=diff[i+1];

        }
        return count+1;
    }
}