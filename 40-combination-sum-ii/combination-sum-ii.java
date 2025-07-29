import java.util.*;

class Solution {
    public void generate(int i, List<Integer> ls, List<List<Integer>> ans, int target, int[] a) {
        if (target == 0) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        for (int j = i; j < a.length; j++) {
            if (j > i && a[j] == a[j - 1]) continue;
            if (a[j] <= target) 
        {
            ls.add(a[j]);
            generate(j + 1, ls, ans, target - a[j], a); 
            ls.remove(ls.size() - 1);
        }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);  // Sort to handle duplicates
        generate(0, new ArrayList<>(), ans, target, candidates);
        return ans;
    }
}
