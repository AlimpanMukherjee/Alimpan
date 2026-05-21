
class Solution {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        Set<Integer> set = new HashSet<>();

        int n = arr1.length;
        int m = arr2.length;

        for (int i = 0; i < n; i++) {

            int num = arr1[i];

            int len = (int)Math.log10(num) + 1;

            for (int j = len - 1; j >= 0; j--) {

                int a = (int)(num / Math.pow(10, j));

                set.add(a);
            }
        }

        int maxlen = 0;

        for (int i = 0; i < m; i++) {

            int num = arr2[i];

            int len = (int)Math.log10(num) + 1;

            for (int j = len - 1; j >= 0; j--) {

                int a = (int)(num / Math.pow(10, j));

                if (set.contains(a)) {

                    int templen = (int)Math.log10(a) + 1;

                    maxlen = Math.max(maxlen, templen);
                }
            }
        }

        return maxlen;
    }
}

