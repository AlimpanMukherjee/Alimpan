import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> stck = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < asteroids.length; i++) {
            int a = asteroids[i];

            // Process collision only if stack is not empty
            while (j > 0 && stck.get(j - 1) > 0 && a < 0) {
                int top = stck.get(j - 1);
                if (top < -a) {
                    stck.remove(j - 1);
                    j--;
                } else if (top == -a) {
                    stck.remove(j - 1);
                    j--;
                    a = 0; // both explode
                    break;
                } else {
                    a = 0; // current asteroid explodes
                    break;
                }
            }

            if (a != 0) {
                stck.add(a);
                j++;
            }
        }

        // Convert List to array
        int[] result = new int[stck.size()];
        for (int i = 0; i < stck.size(); i++) {
            result[i] = stck.get(i);
        }
        return result;
    }
}
