class Solution {
    public int searchfirst(int[] a, int l, int r, int x) {
        if (r >= l && l <= a.length - 1) {
            int mid = l + (r - l) / 2;

            if (mid > 0 && a[mid] == x && a[mid - 1] == x) {
                return searchfirst(a, l, mid - 1, x);
            } else if (a[mid] == x) {
                return mid;
            }

            if (a[mid] > x) {
                return searchfirst(a, l, mid - 1, x);
            } else {
                return searchfirst(a, mid + 1, r, x);
            }
        }
        return -1;
    }

        public int searchlast(int[] a, int l, int r, int x) {
        if (r >= l && l <= a.length - 1) {
            int mid = l + (r - l) / 2;
            if (mid < a.length - 1 && a[mid] == x && a[mid + 1] == x) {
                return searchlast(a, mid + 1, r, x);
            } else if (a[mid] == x) {
                return mid;
            }

            if (a[mid] > x) {
                return searchlast(a, l, mid - 1, x);
            } else {
                return searchlast(a, mid + 1, r, x);
            }
        }
        return -1; 
    }
public int[] searchRange(int[] a, int target) {
        int first = searchfirst(a, 0, a.length - 1, target);
        int last = searchlast(a, 0, a.length - 1, target);
        return new int[]{first, last};
    }
}