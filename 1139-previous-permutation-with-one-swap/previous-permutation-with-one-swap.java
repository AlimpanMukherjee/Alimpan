class Solution {
   
    public int[] prevPermOpt1(int[] a) {
        int index=-1;
        int n=a.length;
        for(int i=n-2;i>=0;i--)
        {
            if(a[i]>a[i+1])
            {
                index=i;
                break;
            } 
        }
        if(index==-1)return a;
        int least=-1;
        for(int i=index+1;i<n;i++)
        {
            if(a[i]<a[index])
            {
                if(least==-1 || a[least]<a[i])
                {
                    least=i;
                }
            }
            
        }
        int temp=a[index];
        a[index]=a[least];
        a[least]=temp;
        for(int i=0;i<n;i++)
        {
            System.out.println(a[i]);
        }
        return a;
    }
}