import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] dummy = new int[n][2];

        for (int i = 0; i < n; i++) {
            dummy[i][0] = intervals[i][0]; // store start
            dummy[i][1] = i;               // store index
        }

        Arrays.sort(dummy, (a, b) -> Integer.compare(a[0], b[0]));

        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            int target = intervals[i][1]; // we want the first interval whose start >= this end
            int low = 0, high = n - 1;
            int ans = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (dummy[mid][0] >= target) {
                    ans = dummy[mid][1];  // candidate found
                    high = mid - 1;       // search left for smaller start
                } else {
                    low = mid + 1;
                }
            }

            count[i] = ans;
        }

        return count;
    }
}
