class Solution {
    public boolean rotateString(String s, String goal) {

        int n = s.length();
        if (n != goal.length()) return false;

        StringBuilder org = new StringBuilder(s);

        for (int count = 0; count < n; count++) {

            // take first char
            char first = org.charAt(0);

            // remove first char
            org.deleteCharAt(0);

            // append it at end
            org.append(first);

            // check
            if (org.toString().equals(goal)) return true;
        }

        return false;
    }
}