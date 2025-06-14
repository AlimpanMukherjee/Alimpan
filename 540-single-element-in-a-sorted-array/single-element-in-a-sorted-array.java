class Solution {
    public int singleNonDuplicate(int[] a) {
        if(a.length==1)return a[0];
        if (a[0]!=a[1]) return a[0];
        if(a[a.length-1]!=a[a.length-2]) return a[a.length-1];
        int low=1;
        int high=a.length-2;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(a[mid]!=a[mid+1] && a[mid]!=a[mid-1])return a[mid];
            if((mid%2==0 && a[mid]==a[mid+1])||(mid%2==1 && a[mid]==a[mid-1]))
            {
                low=mid+1;
            }
            else 
            {
                high=mid-1;
            }
        }
        return -1;
    }
}