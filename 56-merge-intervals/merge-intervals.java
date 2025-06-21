class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int first = intervals[0][0];
        int last = intervals[0][1];

        List<int[]> ans = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= last) {
                last = Math.max(last, intervals[i][1]);
            } else {
                ans.add(new int[]{first, last});
                first = intervals[i][0];
                last = intervals[i][1]; // ✅ Added semicolon
            }
        }

        ans.add(new int[]{first, last}); // Add the last merged interval
        return ans.toArray(new int[ans.size()][]);
    }
}
