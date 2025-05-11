class Solution {
    String reverse(String input)
    {
         return new StringBuilder(input).reverse().toString();
    }
    public int longestPalindromeSubseq(String text1) {
        String text2=reverse(text1);
        int n=text1.length();
        int m=text2.length();
        int[][] mat=new int[n+1][m+1];

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    mat[i][j]=mat[i-1][j-1]+1;
                }
                else
                {
                    mat[i][j]=Math.max(mat[i-1][j],mat[i][j-1]);
                }
            }
        }
        return mat[n][m];
    }
}