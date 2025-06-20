class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        long result = 1;
        ans.add(1); // C(rowIndex, 0)
        rowIndex++;

        for (int i = 1; i < rowIndex; i++) {
            result = result * (rowIndex - i ) / i;
            ans.add((int) result); // Convert long to int safely here
        }

        return ans;
    }
}
