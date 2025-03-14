class Solution {
    public int findDuplicate(int[] nums) {
        int i;
        int largest=nums[0];
        int n=nums.length;
        for(i=0;i<n;i++)
        {
            if(nums[i]>largest)
            {
                largest=nums[i];
            }
        }
        int b[]=new int[largest+1];
        for(i=0;i<largest+1;i++)
        {
            b[i]=0;
        }
        for(i=0;i<n;i++)
        {
            b[nums[i]]=b[nums[i]]+1;
        }
        for(i=0;i<largest+1;i++)
        {
            if(b[i]>1)
            {
                return i;
            }
        }
        return 0;
    }
}