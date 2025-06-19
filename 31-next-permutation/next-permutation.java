class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int dip_index = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                dip_index = i;
                break;
            }
        }

        if (dip_index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > dip_index; i--) {
            if (nums[i] > nums[dip_index]) {
                int temp = nums[i];
                nums[i] = nums[dip_index];
                nums[dip_index] = temp;
                break;
            }
        }

        reverse(nums, dip_index + 1, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
