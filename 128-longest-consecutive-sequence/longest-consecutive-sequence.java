class Solution {
    public int longestConsecutive(int[] nums) {
        Set <Integer> n=new HashSet<>();
        if(nums.length==0)return 0;
        int maxcount=1;
        for (int num : nums) {
            n.add(num); 
        }
        for(int num:n)
        {
            if(n.contains(num-1))continue;
            else
            {
                int count=1;
                int target=num;
                while(n.contains(target+1))
                {
                    count++;
                    target++;
                }
                maxcount=Math.max(count,maxcount);
            }
        }
        return maxcount;
    }
}