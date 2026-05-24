class Solution {

    int dp[];

    int func(int[] arr, int d, int n, int idx) {

        if (dp[idx] != -1)
            return dp[idx];

        int steps = 0;

        int flag1 = 0;
        int flag2 = 0;

        for (int i = 1; i <= d; i++) {

            int front = 0;
            int back = 0;

            // right
            if (idx + i < n && flag1 == 0) {

                if (arr[idx + i] < arr[idx]) {

                    front = 1 + func(arr, d, n, idx + i);

                } else {

                    flag1 = 1;
                }
            }

            // left
            if (idx - i >= 0 && flag2 == 0) {

                if (arr[idx - i] < arr[idx]) {

                    back = 1 + func(arr, d, n, idx - i);

                } else {

                    flag2 = 1;
                }
            }

            steps = Math.max(steps,
                    Math.max(front, back));
        }

        return dp[idx] = steps;
    }

    public int maxJumps(int[] arr, int d) {

        int n = arr.length;

        dp = new int[n];

        Arrays.fill(dp, -1);

        int steps = 0;

        for (int i = 0; i < n; i++) {

            steps = Math.max(steps,
                    func(arr, d, n, i));
        }

        return steps + 1;
    }
}