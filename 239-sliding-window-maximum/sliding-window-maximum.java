class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        if (k <= 0) return new int[0];
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int result[] = new int[n - k + 1];
        
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peek() <= i - k) {
                dq.poll();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.add(i);
            if (i >= k - 1) result[i - k + 1] = nums[dq.peek()];        
        }
        
        return result;
    }
}
