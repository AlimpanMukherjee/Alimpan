class Solution {
    public static boolean check(int arr[], int k, int mid) {
        int count = 1;
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            if (total + arr[i] > mid) {
                total = arr[i];
                count++;
            } else {
                total += arr[i];
            }
        }
        return count > k;
    }
    public int splitArray(int[] arr, int k) {
        if (arr.length < k) return -1;

        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(arr, k, mid)) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }
}