class Solution {
    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);
        int flag=-1;
        for(int i=0;i<nums1.length;i++)
        {
            if(nums1[i]%2!=0)
            {
                flag=1;
                break;
            }
        }
        if(flag==-1)return true;
        int odd=0;
        for(int i=0;i<nums1.length;i++)
        {
            if(nums1[i]%2==0)
            {
                if(odd==0)return false;
            }
            else odd++;
        }
        return true;
    }
}