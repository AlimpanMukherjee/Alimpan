class Solution {
    public boolean search(int[] a, int target) {
        int low=0;
            int high=a.length-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if (a[mid]==target)return true;
                if(a[low]==a[mid] && a[mid]==a[high])
                {
                    low=low+1;
                    high=high-1;
                    continue;
                }
                //If the left part is sorted
                if(a[low]<=a[mid])
                {
                    if(target>=a[low] && target<=a[mid]) high=mid-1;
                    else low=mid+1;
                }
                //If thr right part is sorted
                if(a[mid]<=a[high])
                {
                    if(target<=a[high] && target>=a[mid]) low=mid+1;
                    else high=mid-1;
                }
            }
            return false;
    }
}