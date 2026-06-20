class Solution {
    boolean func(int l,int r,int m,int leftlim,int rightlim)
    {
        int gap=r-l;
        //if(gap==-1 && m==leftlim && m==rightlim)return true;
        int leftsum=m-leftlim;
        int rightsum=0;
        if(rightlim>m)rightsum=rightlim-m;
        else rightsum=m-rightlim;
        if((leftsum+rightsum)<=gap)return true;
        return false;
    }
    int check(int left,int right,int leftlim,int rightlim)
    {
        int l=leftlim;
        int r=leftlim+(right-left);
        int ans=0;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(func(left,right,mid,leftlim,rightlim))
            {
                ans=mid;
                l=mid+1;
                
            }
            else
            {
                r=mid-1;
            }
        }
        return ans;
    }
    public int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions,(a,b)->a[0]-b[0]);
        if(restrictions.length==0)return n-1;
        int start=0;
        restrictions[0][1]=Math.min(restrictions[0][1],restrictions[0][0]-1);

        for(int i=1;i<restrictions.length;i++)
        {
            restrictions[i][1]=Math.min(restrictions[i][1],restrictions[start][1]+restrictions[i][0]-restrictions[start][0]);
            start=i;
        }

        int last=restrictions.length-1;
        for(int i=restrictions.length-2;i>=0;i--)
        {
            restrictions[i][1]=Math.min(restrictions[i][1],restrictions[last][1]+restrictions[last][0]-restrictions[i][0]);
            last=i;
        }
        for(int i=0;i<restrictions.length;i++)
        {
            System.out.printf("[%d,%d],",restrictions[i][0],restrictions[i][1]);
        }
        int maxi=0;
        maxi=Math.max(maxi,check(1,restrictions[0][0],0,restrictions[0][1]));

        for(int i=0;i<restrictions.length;i++)
        {
            int val=0;
            if(i==restrictions.length-1)val=check(restrictions[i][0],n,restrictions[i][1],restrictions[i][1] + (n - restrictions[i][0]));
            else val=check(restrictions[i][0],restrictions[i+1][0],restrictions[i][1],restrictions[i+1][1]);
            maxi=Math.max(maxi,val);
        }
        return maxi;
    }
}