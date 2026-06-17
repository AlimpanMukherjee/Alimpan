class Solution {
    public char processStr(String s, long k) {
        long len=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='*')
            {
                if(len>0)len--;
            }
            else if(s.charAt(i)=='#')len*=2;
            else if(s.charAt(i)=='%')continue;
            else len+=1;
        }
        if(k>=len)return '.';
        for(int i=s.length()-1;i>=0;i--)
        {
            
            if(s.charAt(i)=='*')len+=1;
            else if(s.charAt(i)=='#')
            {
                len/=2;
                if(len<=k)k-=len;
            }
            else if(s.charAt(i)=='%')
            {
                k=len-1-k;
            }
            else
            {
                len--;
                if(len==k)return s.charAt(i);
            }    
        }
        return '.';
    }
}