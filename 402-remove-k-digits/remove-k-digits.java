class Solution {
    public String removeKdigits(String num, int k) {
        char[] nums = num.toCharArray();
        Stack<Character> st = new Stack<>();

        if (k == num.length()) return "0";

        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && st.peek() > nums[i] && k > 0) {
                st.pop();
                k--;
            }
            st.push(nums[i]);
        }
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        StringBuilder str = new StringBuilder();
        while (!st.isEmpty()) {
            str.append(st.pop());
        }
        str.reverse();

        
        while (str.length() > 0 && str.charAt(0) == '0') {
            str.deleteCharAt(0);
        }

        return str.length() == 0 ? "0" : str.toString();
    }
}
