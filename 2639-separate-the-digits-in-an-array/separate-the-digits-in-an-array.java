class Solution {
    public int[] separateDigits(int[] nums) {

        int n = nums.length;

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int num = nums[i];

            List<Integer> dummy = new ArrayList<>();

            while (num > 0) {

                int a = num % 10;
                dummy.add(a);

                num = num / 10;
            }

            for (int j = dummy.size() - 1; j >= 0; j--) {

                ans.add(dummy.get(j));
            }
        }

        int m = ans.size();

        int finalAns[] = new int[m];

        for (int i = 0; i < m; i++) {

            finalAns[i] = ans.get(i);
        }

        return finalAns;
    }
}