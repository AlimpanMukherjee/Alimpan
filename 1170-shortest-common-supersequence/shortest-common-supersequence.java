class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] mat = new int[n + 1][m + 1];

        // Fill LCS DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }

        // Backtrack to build the Shortest Common Supersequence
        StringBuilder res = new StringBuilder();
        int i = n, j = m;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                res.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (mat[i - 1][j] > mat[i][j - 1]) {
                res.append(str1.charAt(i - 1));
                i--;
            } else {
                res.append(str2.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters from str1 and str2
        while (i > 0) {
            res.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            res.append(str2.charAt(j - 1));
            j--;
        }

        return res.reverse().toString();
    }
}
