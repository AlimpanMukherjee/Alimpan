class Solution {
    public boolean check(int[] a) {
        int breakpoint = -1;
        int n = a.length;

        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                if (breakpoint != -1) return false; // More than one drop
                breakpoint = i;
            }
        }

        if (breakpoint == -1) return true; // Already sorted

        // Check if rotated part is valid
        for (int i = breakpoint + 1; i < n; i++) {
            if (a[i] < a[i - 1]) return false;
        }

        // Ensure last element <= first only if array is rotated
        return a[n - 1] <= a[0];
    }
}
