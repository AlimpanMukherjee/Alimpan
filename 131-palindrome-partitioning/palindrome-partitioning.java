class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(0, s, new ArrayList<>());
        return ans;
    }

    public void backtrack(int index, String s, List<String> path) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                backtrack(i + 1, s, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
