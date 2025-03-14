class Solution {
    public int bulbSwitch(int n) {
        // int a[]=new int[n];
        // int i,j;
        // for(i=0;i<n;i++)
        // {
        //     a[i]=1;
        // }
        // for(i=1;i<n;i=i+2)
        // {
        //         a[i]=0;
        // }
        // for(i=2;i<n;i++)
        // {
        //     for(j=i;j<n;j=j+i+1)
        //     {
        //         if(a[j]==0)
        //         {
        //             a[j]=1;
        //         }
        //         else
        //         {
        //             a[j]=0;
        //         }
        //     }
        // }
        // int count=0;
        // for(i=0;i<n;i++)
        // {
        //     if(a[i]==1)
        //     {
        //         count++;
        //     }
        // }
        return (int) Math.sqrt(n);
       
    }
}