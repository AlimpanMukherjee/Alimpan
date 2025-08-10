class Solution {
    public int maxScore(int[] a, int k) {
        int lsum=0;
        int rsum=0;
        int n=a.length;
        for(int i=0;i<k;i++)
        {
            lsum+=a[i];
        }
        int maxsum=lsum;
        int right=n-1;
        for(int i=k-1;i>=0;i--)
        {
            lsum-=a[i];
            rsum+=a[right];
            right--;
            maxsum=Math.max(maxsum,lsum+rsum);
        }
        return maxsum;
    }
}