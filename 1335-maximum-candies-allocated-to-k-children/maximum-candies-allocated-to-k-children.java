import java.util.Arrays;

class Solution {
    public long check(int[] a, int mid) {
        long count = 0;
        for (int n : a) {
            count += n / mid;
        }
        return count;
    }

    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = Arrays.stream(candies).max().getAsInt();
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long count = check(candies, mid);

            if (count >= k) {
                ans = mid;       
                low = mid + 1;
            } else {
                high = mid - 1; 
            }
        }

        return ans;
    }
}
