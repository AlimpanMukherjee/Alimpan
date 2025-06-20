class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        
        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        int maxcount = 1;

        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            int count = 1;

            if (target == 1) {
                int ones = hash.get(1);
                if (ones % 2 == 1) {
                    maxcount = Math.max(maxcount, ones);
                } else {
                    maxcount = Math.max(maxcount, ones - 1);
                }
                continue;
            }

            while (hash.getOrDefault(target, 0) >= 2) {
                if ((long) target * target > Integer.MAX_VALUE) break;
                target = target * target;
                count += 2;
            }

            if (hash.getOrDefault(target, 0) == 0) count -= 2;

            maxcount = Math.max(maxcount, count);
        }

        return maxcount;
    }
}
