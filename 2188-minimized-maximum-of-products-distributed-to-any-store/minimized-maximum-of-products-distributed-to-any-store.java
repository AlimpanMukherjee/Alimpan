class Solution {
    public int check(int []a,int mid)
    {
        int count=0;
        for(int num:a)
        {
            while(num>0)
            {
                count++;
                num-=mid;
            }
        }
        return count;
    }
    public int minimizedMaximum(int n, int[] a) {
        int low=1;
        int high=Arrays.stream(a).max().getAsInt();
        int ans=Arrays.stream(a).max().getAsInt();;
        if(a.length==1)return a[0];
        while(low<=high)
        {
            int mid=(low+high)/2;
            int count=check(a,mid);
            if(count>n)
            {
                low=mid+1;
            }
            else
            {
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
        
    }
}