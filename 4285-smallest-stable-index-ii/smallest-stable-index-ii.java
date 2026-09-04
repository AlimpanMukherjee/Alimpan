class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int arr[]=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            min=Math.min(min,nums[i]);
            arr[i]=Math.min(nums[i],min);
            
        }
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,nums[i]);
            if(max-arr[i]<=k)return i;
        }
        return -1;
    }
}