import java.util.*;

class Solution {
    public long[] distance(int[] nums) {

        int n = nums.length;

        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Long> sum = new HashMap<>();

        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Long> sum1 = new HashMap<>();

        long[] ans = new long[n];

        // LEFT → RIGHT
        for (int i = 0; i < n; i++) {

            int val = nums[i];

            int fr = freq.getOrDefault(val, 0);
            long ts = sum.getOrDefault(val, 0L);

            ans[i] = (long) fr * i - ts;

            freq.put(val, fr + 1);
            sum.put(val, ts + i);
        }

        // RIGHT → LEFT
        for (int i = n - 1; i >= 0; i--) {

            int val = nums[i];

            int fr = freq1.getOrDefault(val, 0);
            long ts = sum1.getOrDefault(val, 0L);

            ans[i] += ts - (long) fr * i;

            freq1.put(val, fr + 1);
            sum1.put(val, ts + i);
        }

        return ans;
    }
}