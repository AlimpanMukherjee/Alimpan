class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum=0;
        int avg=0;
        int count=0;
        if(arr.length<k-1)return 0;
        for(int i=0;i<k;i++)
        {
            sum+=arr[i];
        }
        avg=sum/k;
        if(avg>=threshold)count+=1;

        int l=0;
        int r=k-1;
        
        while(r<arr.length-1)
        {
            sum-=arr[l];
            l++;
            r++;
            sum+=arr[r];
            avg=sum/k;
            if(avg>=threshold)count+=1;
        }
        return count;
    }
}