class Solution {
    public int[] closestDivisors(int num) {
        int mindiff=Integer.MAX_VALUE;
        int a[]=new int[2];
        // for(int i=1;i*i<=num;i++)
        // {
        //     if(num%i==0)
        //     {
        //         if(mindiff>(num/i)-i)
        //         {
        //         a[0]=i;
        //         a[1]=num/i;
        //         mindiff=(num/i)-i;
        //         }
        //     }
        // }
        num=num+1;
        for(int i=1;i*i<=num;i++)
        {
            if(num%i==0)
            {
                if(mindiff>(num/i)-i)
                {
                a[0]=i;
                a[1]=num/i;
                mindiff=(num/i)-i;
                }
            }
        }
        num=num+1;
        for(int i=1;i*i<=num;i++)
        {
            if(num%i==0)
            {
                if(mindiff>(num/i)-i)
                {
                a[0]=i;
                a[1]=num/i;
                mindiff=(num/i)-i;
                }
            }
        }
        return a;
    }
}