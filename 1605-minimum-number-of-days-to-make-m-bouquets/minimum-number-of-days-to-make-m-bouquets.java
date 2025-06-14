import java.util.Arrays;

class Solution {
    public boolean check(int[] bloomDay, int m, int k, int mid) {
        int count = 0;
        int bouquets = 0;

        for (int bloom : bloomDay) {
            if (bloom <= mid) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;  
                }
            } else {
                count = 0; 
            }
        }
        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;

        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int ans = -1; 

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;  
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
