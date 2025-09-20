import java.util.*;

class Solution {

    public long sumSubarrayMins(int[] arr) {
        long total = 0;
        Stack<Integer> st = new Stack<>();
        
        int n = arr.length;
        int[] nse = new int[n];
        int[] pse = new int[n]; 

        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();
        // Previous Smaller Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            total += left * right * (long)arr[i];
        }

        return total;
    }

    public long sumSubarrayMax(int[] arr) {
        long total = 0;
        Stack<Integer> st = new Stack<>();
        
        int n = arr.length;
        int[] nge = new int[n];
        int[] pge = new int[n]; 

        // Next Greater Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();
        // Previous Greater Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) st.pop();
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            total += left * right * (long)arr[i];
        }

        return total;
    }

    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMins(nums);
    }
}
