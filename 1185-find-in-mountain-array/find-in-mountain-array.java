class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int low = 0;
        int high = mountainArr.length() - 1;
        int index = -1;  // initialize index

        // Find the peak index
        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = mountainArr.get(mid);
            int leftVal = (mid > 0) ? mountainArr.get(mid - 1) : Integer.MIN_VALUE;
            int rightVal = (mid < mountainArr.length() - 1) ? mountainArr.get(mid + 1) : Integer.MIN_VALUE;

            if (midVal > leftVal && midVal > rightVal) {
                index = mid;
                break;
            }
            if (midVal > leftVal) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Binary search in increasing part [0...index]
        int low1 = 0, high1 = index;
        int ans = -1;
        while (low1 <= high1) {
            int mid1 = (low1 + high1) / 2;
            int val = mountainArr.get(mid1);
            if (val == target) {
                ans = mid1;
                high1 = mid1 - 1; // continue searching left for smaller index
            } else if (val < target) {
                low1 = mid1 + 1;
            } else {
                high1 = mid1 - 1;
            }
        }
        if (ans != -1) return ans;

        // Binary search in decreasing part [index+1...n-1]
        int low2 = index + 1, high2 = mountainArr.length() - 1;
        while (low2 <= high2) {
            int mid2 = (low2 + high2) / 2;
            int val = mountainArr.get(mid2);
            if (val == target) {
                return mid2;
            } else if (val < target) {
                high2 = mid2 - 1;
            } else {
                low2 = mid2 + 1;
            }
        }

        return -1;
    }
}
