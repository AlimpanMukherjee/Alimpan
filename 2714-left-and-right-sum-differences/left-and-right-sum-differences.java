class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;

        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int[] result = new int[n];

        // Build left prefix sum
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }

        // Build right suffix sum
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }

        // Compute absolute differences
        for (int i = 0; i < n; i++) {
            result[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return result;
    }
}
