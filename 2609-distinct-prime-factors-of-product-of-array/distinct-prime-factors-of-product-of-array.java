import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> primeFactors = new HashSet<>();
        
        for (int num : nums) {
            if (num < 2) continue;
            int n = num;
            for (int i = 2; i * i <= n; i++) {
                while (n % i == 0) {
                    primeFactors.add(i);
                    n /= i;
                }
            }
            if (n > 1) {
                primeFactors.add(n); // Remaining prime factor
            }
        }
        
        return primeFactors.size();
    }
}