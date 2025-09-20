class Solution {
    public int sumSubarrayMins(int[] arr) {
        long total = 0;
        long mod = (long)1e9 + 7;
        Stack<Integer> st = new Stack<>();
        
        int n = arr.length;
        int[] nse = new int[n];
        int[] pse = new int[n]; 
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            total = (total + (left * right % mod) * arr[i]) % mod;
        }

        return (int) total;
    }
}
