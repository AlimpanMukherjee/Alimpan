class Solution {
    public void rotate(int[][] a) {
        int n=a.length;
        int i,j,temp,l,r;
        for(i=0;i<n;i++)
        {
            for(j=i+1;j<n;j++)
            {
                temp=a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=temp;
            }
        }
        for(i=0;i<n;i++)
        {
            l=0;
            r=n-1;
            while(l<r)
            {
                temp=a[i][l];
                a[i][l]=a[i][r];
                a[i][r]=temp;
                l++;
                r--;
            }
        }
    }
}