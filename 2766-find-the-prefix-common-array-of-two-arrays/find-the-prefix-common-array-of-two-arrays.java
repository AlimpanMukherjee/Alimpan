class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int []dp=new int[n];
        if(A[0]==B[0])dp[0]=1;

        for(int i=1;i<n;i++)
        {
            if(A[i]==B[i])dp[i]=dp[i-1]+1;
            else
            {
                int count=0;
                for(int j=0;j<=i-1;j++)
                {
                    if(A[i]==B[j])count++;
                    if(B[i]==A[j])count++;
                    if(count==2)break;
                }
                dp[i]=dp[i-1]+count;
            }
            
        }
        return dp;
    }
}