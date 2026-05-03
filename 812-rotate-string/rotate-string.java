class Solution {
    public boolean rotateString(String s, String goal) {
       
        int n = s.length();
        int m = goal.length();

        if (n != m) return false;

        StringBuilder org = new StringBuilder(s);

        for (int count = 0; count < n; count++) {

            // store first character
            char zero = org.charAt(0);

            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    org.setCharAt(i, zero);
                } else {
                    org.setCharAt(i, org.charAt(i + 1));
                }
            }

            String x = org.toString();
            if (x.equals(goal)) return true;
        }
        return false;
    }
}