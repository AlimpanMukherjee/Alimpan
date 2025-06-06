class Solution {
    public int minDistance(String word1, String word2) {
       int n=word1.length();
       int m=word2.length();
       int[][] mat=new int[n+1][m+1];
       for(int i=0;i<=n;i++)mat[i][0]=i;
       for(int j=0;j<=m;j++)mat[0][j]=j;
       int corner,up,left;

       for(int i=1;i<=n;i++)
       {
        for(int j=1;j<=m;j++)
        {
            if(word1.charAt(i-1)==word2.charAt(j-1))
            {
                mat[i][j]=mat[i-1][j-1];
            }
            else
            {
                corner=mat[i-1][j-1];
                up=mat[i][j-1];
                left=mat[i-1][j];
                mat[i][j]=Math.min(corner,Math.min(up,left))+1;
            }
        }
       }
       return mat[n][m];
    }
}