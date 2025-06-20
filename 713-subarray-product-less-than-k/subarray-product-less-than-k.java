class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int first = 0;
        int count = 0;
        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (product >= k && first <= i) {
                product /= nums[first];
                first++;
            }
            count += i - first + 1;
        }

        return count;
    }
}
