import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? -1 : st.peek();
            map.put(nums2[i], nge[i]);
            st.push(nums2[i]);
        }
        int[] nge2 = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            nge2[i] = map.get(nums1[i]);
        }
        
        return nge2;
    }
}
