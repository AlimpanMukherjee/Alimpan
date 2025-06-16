class Solution {
    public int findKthPositive(int[] a, int k) {
        int low=0;
        int high=a.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(a[mid]-(mid+1)<k)
            low=mid+1;
            else
            high=mid-1;
        }
        return high==-1?k:a[high]+(k-(a[high]-(high+1)));
    }
}