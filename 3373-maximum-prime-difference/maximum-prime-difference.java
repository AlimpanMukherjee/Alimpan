class Solution {
    public boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public int maximumPrimeDifference(int[] nums) {
        Integer firstIndex = 0;
        Integer lastIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
               firstIndex=i;
               break;
            }
        }
        for(int i=nums.length-1;i>=0;i--)
        {
            if(isPrime(nums[i]))
            {
                lastIndex=i;
                break;
            }
        }

        //if (firstIndex == -1) return 0;
        return lastIndex - firstIndex;
    }
}