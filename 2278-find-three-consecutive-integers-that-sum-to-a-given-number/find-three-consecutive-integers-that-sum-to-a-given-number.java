class Solution {
    public long[] sumOfThree(long num) {
        
        long mid=num/3;
        long []a=new long[3];
        if(num%3!=0)return new long[0];        
        a[0]=mid-1;
        a[1]=mid;
        a[2]=mid+1;
        
        return a;
    }
}