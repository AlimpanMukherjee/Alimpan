class Solution {
   
    public int countDigitOne(int n) {

        if(n==0)
        {
            return 0;
        }
        if(n<10)
        {
            return 1;
        }
        
        int base=(int)Math.pow(10,(int)Math.log10(n));
        int mul=n/base;
        int rem=n%base;

        int x;
        if(mul==1)
        {
            x=n-base+1;
        }
        else
        {
            x=base;
        }

        return countDigitOne(base-1)*mul+x+countDigitOne(rem);

    }   
}