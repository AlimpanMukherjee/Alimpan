class Solution {
    boolean isValid(int i)
    {
        int len = (int) Math.log10(i) + 1; 
        int []org=new int[len];
        int []rev=new int[len];
        int j=len-1;
        while(i>0)
        {
            int a=i%10;
            if(a==2 || a==5 || a==6 || a==9 || a==0 || a==1 || a==8)
            {
                org[j]=a;
                if(a==2)rev[j]=5;
                else if(a==5)rev[j]=2;
                else if(a==6)rev[j]=9;
                else if(a==9)rev[j]=6;
                else rev[j]=a;
                j--;              
            }
            else return false;
            i=i/10;
        }
        for(j=0;j<len;j++)
        {
            if(org[j]!=rev[j])return true;
        }
        return false;
    }
    public int rotatedDigits(int n) {
        int count=0;
        Set<Integer> set=new HashSet<>();
        
        

        for(int i=1;i<=n;i++)
        {
            if(isValid(i))count++;
        }
        return count;
    }
}