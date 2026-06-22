class Solution {
    int first(int arr[],int target)
    {
        int l=0;
        int h=arr.length-1;
        int ans=-1;
        while(l<=h)
        {
            int m=(l+h)/2;
            if(arr[m]<target)
            {
                l=m+1;
            }
            else
            {
                if(arr[m]==target)ans=m;
                h=m-1;
            }
        }
        return ans;
    }

    int second(int arr[],int target)
    {
        int l=0;
        int h=arr.length-1;
        int ans=-1;
        while(l<=h)
        {
            int m=(l+h)/2;
            if(arr[m]<=target)
            {
                if(arr[m]==target)ans=m;
                l=m+1;
            }
            else
            {                
                h=m-1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        
        int ans[]=new int[2];
        if(nums.length==0)
        {
            ans[0]=-1;
            ans[1]=-1;
            return ans;
        }
        ans[0]=first(nums,target);
        ans[1]=second(nums,target);
        return ans;
    }
}