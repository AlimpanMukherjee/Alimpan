class Solution {
    public int cal(int a)
    {
        int sum=0,k;
        while(a>0)
        {
            k=a%10;
            sum+=k*k;
            a=a/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = cal(n);
        }
        
        return n == 1;
    }
}