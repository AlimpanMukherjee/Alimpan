import java.util.*;

class Solution {

    public int minJumps(int[] nums) {

        int n = nums.length;
        if (n == 1) return 0;

        // prime -> all indices whose nums[i] divisible by prime
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Build factor buckets
        for (int i = 0; i < n; i++) {
            int x = nums[i];

            for (int p = 2; p * p <= x; p++) {
                if (x % p == 0) {

                    map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);

                    while (x % p == 0) {
                        x /= p;
                    }
                }
            }

            if (x > 1) {
                map.computeIfAbsent(x, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int idx = q.poll();

                if (idx == n - 1) return steps;

                // adjacent left
                if (idx - 1 >= 0 && !vis[idx - 1]) {
                    vis[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // adjacent right
                if (idx + 1 < n && !vis[idx + 1]) {
                    vis[idx + 1] = true;
                    q.offer(idx + 1);
                }

                int val = nums[idx];

                // teleport only if current value itself is prime
                if (isPrime(val)) {

                    List<Integer> next = map.get(val);

                    if (next != null) {

                        for (int ni : next) {

                            if (!vis[ni]) {
                                vis[ni] = true;
                                q.offer(ni);
                            }
                        }

                        // very important to avoid TLE
                        map.remove(val);
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private boolean isPrime(int x) {

        if (x < 2) return false;

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }

        return true;
    }
}