class Solution {
    public void generate(int index, List<Integer> ls, List<List<Integer>> ans, int target, int k) {
        if (target == 0 && ls.size() == k) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        if (target < 0 || ls.size() >= k)
            return;

        for (int i = index; i <= 9; i++) {
            ls.add(i);
            generate(i + 1, ls, ans, target - i, k);
            ls.remove(ls.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        generate(1, ls, ans, n, k);
        return ans;
    }
}
