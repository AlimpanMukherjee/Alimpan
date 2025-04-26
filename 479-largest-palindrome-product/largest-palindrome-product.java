class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;

        long largest = (long) Math.pow(10, n) - 1;
        long smallest = (long) Math.pow(10, n - 1);

        for (long i = largest; i >= smallest; i--) {
            long t = isPalindrome(i); 
            
            for (long j = largest; j * j >= t; j--) {
                if (t % j == 0 && t / j >= smallest) {
                    return (int) (t % 1337);
                }
            }
            
        }
        return 0;
    }

    
    private long isPalindrome(long a) {
        long k = a, b = a;
        while (b > 0) {
            k = k * 10 + (b % 10);
            b /= 10;
        }
        return k;
    }
}
