class Solution {

    public boolean check(int []stalls ,int mid,int k)
    {
        int count=1,last=stalls[0];
        for(int i=1;i<stalls.length;i++)
        {
            
            if(stalls[i]-last>=mid)
            {
                count++;
                last=stalls[i];
            }
        }
        return count>=k;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low=0,high=position[position.length-1]-position[0];
        int ans=1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(check(position,mid,m))
            {
                ans=mid;
                low=mid+1;
            }
            else 
            {
                high=mid-1;
            }
        }
        return ans;
    }
}