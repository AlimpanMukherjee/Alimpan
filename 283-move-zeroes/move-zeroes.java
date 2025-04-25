class Solution {
    public void moveZeroes(int[] nums) {
        int k=0;
        // Arrays.sort(nums);
        // int i,j,t=0;
        // for(i=0;i<nums.length;i++)
        // {
        //     if(nums[i]==0)
        //     {
        //         t++;
        //     }
        // }
        // int l=t;
        // for(j=0;j<nums.length-l;j++)
        // {
        //     nums[j]=nums[t];
        //     t++;
        // }
        // for(int k=j;k<nums.length;k++)
        // {
        //     nums[k]=0;
        // }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                nums[k]=nums[i];
                k++;
            }
        }
        while(k<nums.length)
        {
            nums[k]=0;
            k++;
        }
    }
}