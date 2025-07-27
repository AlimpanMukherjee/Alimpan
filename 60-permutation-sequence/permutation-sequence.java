import java.util.*;

class Solution {

    // Helper method to reverse part of the array
    public void reverse(int[] a, int start, int end) {
        end--; // make end exclusive
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    // Generate the next permutation k times
    public void nextPermutation(int[] a) {
        int n = a.length;
        int index = -1;

        // Step 1: Find first index 'index' from right where a[i] < a[i+1]
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                index = i;
                break;
            }
        }

        // If no such index, it's the last permutation
        if (index == -1) {
            reverse(a, 0, n);
            return;
        }

        // Step 2: Find next greater element to swap
        int nextGreater = -1;
        for (int i = n - 1; i > index; i--) {
            if (a[i] > a[index]) {
                nextGreater = i;
                break;
            }
        }

        // Step 3: Swap and reverse
        int temp = a[index];
        a[index] = a[nextGreater];
        a[nextGreater] = temp;

        reverse(a, index + 1, n);
    }

    public String getPermutation(int n, int k) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }

        for (int i = 1; i < k; i++) {
            nextPermutation(a);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : a) {
            sb.append(num);
        }

        return sb.toString();
    }
}
