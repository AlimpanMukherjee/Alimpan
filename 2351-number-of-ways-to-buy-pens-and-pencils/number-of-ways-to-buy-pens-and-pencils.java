class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long count=0;
        for(int i=0;i<=total;i+=cost1)
        {
            count+=(long)((total-i+cost2)/cost2);
        }
        return count;
    }
}