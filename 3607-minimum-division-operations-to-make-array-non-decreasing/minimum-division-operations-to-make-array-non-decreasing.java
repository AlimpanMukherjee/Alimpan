class Solution {
        public int fix(int last,int first)
        {
            if(first%2==0)
            {
                if(2>last)return -1;
                return 2;
            }
            // for(int i=(first/2);i>=2;i--)
            // {
            //     if(first%i==0)
            //     {
            //         if(last<first/i)return -1;
            //         return first/i;
            //     }

            // }
            for(int i=3;i*i<=first;i+=2)
            {
                if(first%i==0)
                {
                    if(i>last)return -1;
                    return i;
                }
            }
            return -1;
        }
    public int minOperations(int[] nums) {
        int n=nums.length;
        int a;
        int count=0;
        for(int i=n-1;i>=1;i--)
        {
            if(nums[i]>=nums[i-1])continue;
            else 
            {
                a=fix(nums[i],nums[i-1]);
                if(a==-1)return -1;
                nums[i-1]=a;
                count++;
            }
        }
        return count;
    }
}