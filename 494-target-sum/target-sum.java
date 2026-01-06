class Solution {
    int f(int arr[],int idx,int target)
    {
        if(idx==0)
        {
            if(arr[0]==0 && target==0) return 2;
            if(target==0 || target==arr[0])return 1;
            return 0;
        }
        int ntake=f(arr,idx-1,target);
        int take=0;
        if(arr[idx]<=target)take=f(arr,idx-1,target-arr[idx]);
        return take+ntake;
    }
    
    public int findTargetSumWays(int[] arr, int diff) {
        int sum = 0;
        for (int x : arr) sum += x;

        int total = sum + diff;
        if (total % 2 != 0) return 0;

        int target = total / 2;
        int n = arr.length;

        int count=f(arr,n-1,target);
        return count;
    }
}