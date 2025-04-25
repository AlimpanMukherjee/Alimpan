class Solution {
    public String longestPalindrome(String s) {
        int left, right, l = 0;
        String palindrome = "", output = ""; 

        for (int i = 0; i < s.length(); i++) {
            // Odd length center
            left = i;
            right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            palindrome = s.substring(left + 1, right);
            if (l < palindrome.length()) {
                l = palindrome.length();
                output = palindrome;
            }

            // Even length center
            left = i - 1;
            right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            palindrome = s.substring(left + 1, right);
            if (l < palindrome.length()) {
                l = palindrome.length();
                output = palindrome;
            }
        }
        return output;
    }
}
