class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==1)
        {
            return true;
        }
        if(n>=3)
        {
            if(n%3==0)
            return isPowerOfThree(n/3);
            else
            return false;
        }
        return false;
    }
}