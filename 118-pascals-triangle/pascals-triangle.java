class Solution {
    public List<Integer> find(int r) {
        List<Integer> ans = new ArrayList<>();
        int result = 1;
        ans.add(1);
        for (int col = 1; col < r; col++) {
            result = result * (r - col);
            result = result / col;
            ans.add(result);
        }
        return ans;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            ans.add(find(i));
        }
        return ans;
    }
}
