class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        // Set <Integer> n=new HashSet<>();
        // int count=0,maxcount=0;
        // for(int num:special)
        // {
        //     n.add(num);
        // }
        // for(int i=bottom;i<=top;i++)
        // {
        //     if(n.contains(i))
        //     {
        //         count=0;
        //     }
        //     else
        //     {
        //         count++;
        //         maxcount=Math.max(maxcount,count);
        //     }
        // }
        int count=0;
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