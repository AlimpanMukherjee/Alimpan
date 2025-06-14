int search(int* a, int numsSize, int target) {
                int low=0;
            int high=numsSize-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if (a[mid]==target)return mid;
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
            return -1;
}