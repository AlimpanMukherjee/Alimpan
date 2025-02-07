class Solution {
    boolean bs(int low,int high,int []a,int t)
    {
        if(low<=high && low<=a.length-1)
        {
            int mid=(low+high)/2;
            if(a[mid]==t)
            {
                return true;
            }
            else if(a[mid]>t)
            {
                return bs(low,mid-1,a,t);
            }
            else
            {
                return bs(mid+1,high,a,t);
            }
        }
        
        {
            return false;
        }
    }
    public boolean search(int[] nums, int target) {
            Arrays.sort(nums);
            return bs(0,nums.length,nums,target);

    }
}