class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int start = newInterval[0];
        int end = newInterval[1];

        List<int[]> ans = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] <start) {
                ans.add(new int[]{intervals[i][0], intervals[i][1]});
                j = i + 1;
            } else {
                break;
            }
        }

        int i;
        for (i = j; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            } else {
                break;
            }
        }
        ans.add(new int[]{start, end});

        for (j = i; j < intervals.length; j++) {
            ans.add(intervals[j]);
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
