class Solution {
    public void generate(int i, List<Integer> ls, List<List<Integer>> ans, int target, int[] a) {
        if (i == a.length) {
            if(target==0)
            {
                ans.add(new ArrayList<>(ls));
            }
            return;
        }
        if (target >= a[i]) {
            ls.add(a[i]);
            generate(i, ls, ans, target - a[i], a); 
            ls.remove(ls.size() - 1);
        }
        generate(i + 1, ls, ans, target, a);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        generate(0, ls, ans, target, candidates);
        return ans;
    }
}
