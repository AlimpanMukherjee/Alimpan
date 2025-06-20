class Solution {
    public int subarraySum(int[] nums, int k) {
        Map <Integer,Integer> n=new HashMap<>();

        int sum=0,count=0;
        n.put(0,1);

        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            // if(sum==k)count+=1;
            if(n.containsKey(sum-k))
            {
                count+=n.get(sum-k);
            }
            if(n.containsKey(sum))
            {
                n.put(sum,n.get(sum)+1);
            }
            else
            {
                n.put(sum,1);
            }
        }
        return count;
    }
}