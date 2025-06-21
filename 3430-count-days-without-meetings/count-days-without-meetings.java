class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int totalBusy = 0;
        int start = meetings[0][0], end = meetings[0][1];

        for (int i = 1; i < meetings.length; i++) {
            int curStart = meetings[i][0];
            int curEnd = meetings[i][1];

            if (curStart <= end+1 ) {
                end = Math.max(end, curEnd);  // merge
            } else {
                totalBusy += (end - start + 1);
                start = curStart;
                end = curEnd;
            }
        }

        totalBusy += (end - start + 1);  // add last interval
        return days - totalBusy;
    }
}
