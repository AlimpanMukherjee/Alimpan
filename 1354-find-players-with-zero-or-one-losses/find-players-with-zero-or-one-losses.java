class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int[] a : matches) {
            if (!map.containsKey(a[0])) map.put(a[0], 0);
            if (!map.containsKey(a[1])) map.put(a[1], 0);
        }

        for (int[] a : matches) {
            int loser = a[1];
            map.put(loser, map.get(loser) + 1);
        }

        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();

        for (int a : map.keySet()) {
            if (map.get(a) == 0) zero.add(a);
            else if (map.get(a) == 1) one.add(a);
        }

        Collections.sort(zero);
        Collections.sort(one);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(zero);
        ans.add(one);

        return ans;
    }
}
