class Solution {
    public int countCommas(int n) {
        int count=0;
        for(int i=999;i<n;i++)
        {
            if(i<=100000)count+=1;
            else count+=2;            
        }
        return count;
    }
}