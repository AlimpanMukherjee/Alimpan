class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        int l=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++)
        {
            l=Math.max(l,nums[i]);
        }
        if(n<=l)return false;
        if(n!=l+1)return false;
        int a[]=new int[l+1];
        for(int i=0;i<n;i++)
        {
            if(a[nums[i]]==1 && nums[i]!=l)return false;
            a[nums[i]]=1;
        }
        for(int i=1;i<l+1;i++)
        {
            if(a[i]==0 && i!=l)return false;
        }
        return true;

    }
}