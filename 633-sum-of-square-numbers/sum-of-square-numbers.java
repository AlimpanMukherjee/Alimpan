class Solution {
    public boolean judgeSquareSum(int c) {
        long low = 0;
        long high = (long)Math.sqrt(c);  // You can reduce high to sqrt(c) for optimization
        
        while (low <= high) {
            long sum = low * low + high * high;
            if (sum > c) {
                high--;
            } else if (sum < c) {
                low++;
            } else {
                return true;
            }
        }
        return false;
    }
}
