class Solution {
    int mini=Integer.MAX_VALUE;
    void func(int cookies[],int children[],int idx,int k)
    {
        if(idx==cookies.length)
        {
            int maxi=0;
            for(int i=0;i<k;i++)
            {
                maxi=Math.max(maxi,children[i]);
            }
            mini= Math.min(mini,maxi);
            return;
        }
        else
        {
            for(int i=0;i<k;i++)
            {
                children[i]+=cookies[idx];
                func(cookies,children,idx+1,k);
                children[i]-=cookies[idx];
            }
        }
    }
    public int distributeCookies(int[] cookies, int k) {
        
        func(cookies,new int[k],0,k);
        return mini;
    }
}