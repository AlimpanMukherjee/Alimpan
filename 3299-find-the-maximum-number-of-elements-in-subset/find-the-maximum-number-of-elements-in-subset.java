class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int maxi=1;
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        if(map.containsKey(1))
        {
            int count=0;
            count=map.get(1);
            if(count%2==0)count--;
            maxi=Math.max(maxi,count);
        }
        for(int i=0;i<nums.length;i++)
        {
            int num=nums[i];
            if(map.get(num)<=1 || num==1)continue;
            int exp=1;
            int count=0;
            for(int j=1;j<=Integer.MAX_VALUE;j=j*2)
            {
                int num1=(int)Math.pow(num,j);
                if(map.containsKey(num1))
                {
                    if(map.get(num1)==1)
                    {
                        count++;
                        break;
                    }
                    count+=2;
                }
                else break;
            }
            if(count%2==0)count--;
            maxi=Math.max(maxi,count);
        }
        return maxi;
    }
}