
class Solution {
    public int earliestFinishTime(int[] lst, int[] ldu,
                                 int[] wst, int[] wdu) {

        int ans = Integer.MAX_VALUE;
        int t=Integer.MAX_VALUE;

        // if we go for the land ride first
        for (int i = 0; i < lst.length; i++) {
            t = Math.min(t,lst[i] + ldu[i]);
        }
        for(int i=0;i<wst.length;i++)
        {
            if(wst[i]<=t)
            {
                ans=Math.min(ans,t+wdu[i]);
            }
            else
            {
                ans=Math.min(ans,wst[i]+wdu[i]);
            }
        }

        t=Integer.MAX_VALUE;
        for (int i = 0; i < wst.length; i++) {
            t = Math.min(t,wst[i] + wdu[i]);
        }
        for(int i=0;i<lst.length;i++)
        {
            if(lst[i]<=t)
            {
                ans=Math.min(ans,t+ldu[i]);
            }
            else
            {
                ans=Math.min(ans,lst[i]+ldu[i]);
            }
        }       

        return ans;
    }
}