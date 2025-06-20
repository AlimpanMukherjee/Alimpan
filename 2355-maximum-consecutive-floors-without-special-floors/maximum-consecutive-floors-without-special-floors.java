class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        
        int maxcount=0;
        Arrays.sort(special);
        for(int num:special)
        {
            maxcount=Math.max(maxcount,num-bottom);
            bottom=num+1;
        }
        maxcount=Math.max(maxcount,top+1-bottom);
        return maxcount;
    }
}