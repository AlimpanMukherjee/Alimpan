class Solution {
    public int lowerBound(long[] arr, int left, int right, long target)
{
    int l = left, r = right;

    while(l < r)
    {
        int m = (l + r) / 2;
        if(arr[m] >= target) r = m;
        else l = m + 1;
    }

    if(l < right && arr[l] >= target) return l;
    return -1;
}
    public long[] from2d_to_1d(long []arr,int n,int [][]points,int side)
    {
        for(int i=0;i<n;i++)
       {
            int x=points[i][0];
            int y=points[i][1];

            if(y==0)
            {
                arr[i]=x;
            }
            else if(x==side)
            {
                arr[i]=side+y;
            }
            else if(y==side)
            {
                arr[i]=2L*side+(side-x);
            }
            else
            {
                arr[i]=3L*side+(side-y);
            }
       }
       return arr;
    }

    public boolean isPossible(long mid,long []arr,int k,int n,int side)
{
    int total = 2*n;

    for(int i=0;i<n;i++)
    {
        int count=1;
        long first=arr[i];
        long last=arr[i];

        int curr=i;

        while(count<k)
        {
            int next = lowerBound(arr, curr+1, i+n, last+mid);
            if(next == -1) break;

            last = arr[next];
            curr = next;
            count++;
        }

        if(count==k && last-first<=4L*side-mid) return true;
    }
    return false;
}
    public int maxDistance(int side, int[][] points, int k) {
       int n=points.length;
       long arr[]=new long[2*n];

       arr=from2d_to_1d(arr,n,points,side);

       java.util.Arrays.sort(arr,0,n);

       for(int i=0;i<n;i++)
       {
            arr[i+n]=arr[i]+4L*side;
       }

       long left=0;
       long right=2L*side;
       long ans=0;

       while(left<=right)
       {
            long mid=(left+right)/2;
            if(isPossible(mid,arr,k,n,side))
            {
                ans=mid;
                left=mid+1;
            }
            else right=mid-1;
       } 
       return (int)ans;
    }
}