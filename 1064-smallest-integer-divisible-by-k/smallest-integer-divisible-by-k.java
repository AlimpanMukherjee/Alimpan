class Solution {
    public int smallestRepunitDivByK(int k) {
        int i=1,length=1;
        if(k%2==0  || k%5==0)
        {
            return -1;
        }
        else
        {
            while(i%k!=0)
            {
                i=(i*10+1)%k;
                length++;
                if(length>k)
                return -1;
            }
        }
        return length;
    }
}