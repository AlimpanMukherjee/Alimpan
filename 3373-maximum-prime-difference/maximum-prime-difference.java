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
        Integer firstIndex = null;
        Integer lastIndex = null;

        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
                if (firstIndex == null) {
                    firstIndex = i;
                }
                lastIndex = i;
            }
        }

        if (firstIndex == null) return 0; // No primes
        return lastIndex - firstIndex;
    }
}