class Solution {
    public int maximumDifference(int[] nums) {
        int least = nums[0];  // Start from first element
        int greatestdiff = -1;  // Default value if no valid difference found
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > least) {
                greatestdiff = Math.max(greatestdiff, nums[i] - least);
            } else {
                least = nums[i];  // Update least so far
            }
        }
        
        return greatestdiff;
    }
}
