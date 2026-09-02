class Solution {
    public boolean uniformArray(int[] nums1) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,0);
        map.put(0,0);
        for(int i=0;i<nums1.length;i++)
        {
            if(nums1[i]%2==0)map.put(0,map.get(0)+1);
            else map.put(1,map.get(1)+1);
        }
        int flag=-1;
        // for odd array
        for(int i=0;i<nums1.length;i++)
        {
            if(nums1[i]%2==0)
            {
                if(map.get(1)>1)continue;
                else 
                {
                    flag++;
                    break;
                }
            }
        }
        if(flag==-1)return true;
        //for even 
        for(int i=0;i<nums1.length;i++)
        {
            if(nums1[i]%2==1)
            {
                if(map.get(1)>0)continue;
                else
                {
                    flag++;
                    break;
                }
            }
        }
        if(flag==0)return true;
        return false;
    }
}