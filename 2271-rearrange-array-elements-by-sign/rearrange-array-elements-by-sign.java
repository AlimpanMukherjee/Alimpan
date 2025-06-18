import java.util.*;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                neg.add(nums[i]);
            } else {
                pos.add(nums[i]);
            }
        }

        int i;

        if (pos.size() >= neg.size()) {
            for (i = 0; i < neg.size(); i++) {
                nums[2 * i] = pos.get(i);
                nums[2 * i + 1] = neg.get(i);
            }

            int j = 2 * neg.size();
            while (i < pos.size()) {
                nums[j++] = pos.get(i++);
            }
        } else {
            for (i = 0; i < pos.size(); i++) {
                nums[2 * i] = pos.get(i);
                nums[2 * i + 1] = neg.get(i);
            }

            int j = 2 * pos.size();
            while (i < neg.size()) {
                nums[j++] = neg.get(i++);
            }
        }

        return nums;
    }
}
