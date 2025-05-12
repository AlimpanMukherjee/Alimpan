import java.util.*;

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        List<Integer> leftstck = new ArrayList<>();
        List<Integer> rightstck = new ArrayList<>();

        for (int i = 0; i < left.length; i++) {
            leftstck.add(left[i]);
        }

        for (int i = 0; i < right.length; i++) {
            rightstck.add(right[i]);
        }

        int t = 0;

        while (leftstck.size() > 0 || rightstck.size() > 0) {
            // Move left-moving ants
            for (int i = 0; i < leftstck.size(); ) {
                leftstck.set(i, leftstck.get(i) - 1);
                if (leftstck.get(i) == -1) {
                    leftstck.remove(i);
                } else {
                    i++;
                }
            }

            // Move right-moving ants
            for (int i = 0; i < rightstck.size(); ) {
                rightstck.set(i, rightstck.get(i) + 1);
                if (rightstck.get(i) == n + 1) {
                    rightstck.remove(i);
                } else {
                    i++;
                }
            }

            // Only increment time if ants are still on the plank
            if (leftstck.size() > 0 || rightstck.size() > 0) {
                t++;
            }
        }

        return t;
    }
}
