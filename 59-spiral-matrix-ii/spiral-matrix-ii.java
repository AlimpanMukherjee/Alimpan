class Solution {
    public int[][] generateMatrix(int size) {

       int left=0;
       int right=size-1;
       int top=0;
       int bottom=size-1;
       int n=1;
       int [][]a=new int [size][size];
       while(top<=bottom && left<=right)
       {
            for(int i=left;i<=right;i++)
            {
                a[top][i]=n;
                n++;
            }
            top++;
            for(int i=top;i<=bottom;i++)
            {
                a[i][right]=n;
                n++;
            }
            right--;
            if(top<=bottom)
            {
                for(int i=right;i>=left;i--)
                {
                    a[bottom][i]=n;
                    n++;
                }
                bottom--;
            }
            if(left<=right)
            {
                for(int i=bottom;i>=top;i--)
                {
                    a[i][left]=n;
                    n++;
                }
                left++;
            }
       }
       return a;
       
    }
}