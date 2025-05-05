class Solution {
    public int Generate(int a, int b) {
        int temp = b;
        while (temp > 0) {
            a *= 10;
            temp /= 10;
        }
        return a + b;
    }

    public long findTheArrayConcVal(int[] nums) {
        int n = nums.length;
        long total = 0;

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            total += Generate(a, b);
        }

        if (n % 2 == 1) {
            total += nums[n / 2];
        }

        return total;
    }
}
