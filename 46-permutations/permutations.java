class Solution {
    public int factorial(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    public void reverse(List<Integer> a, int low, int high) {
        while (low < high) {
            int temp = a.get(low);
            a.set(low, a.get(high));
            a.set(high, temp);
            low++;
            high--;
        }
    }

    public List<Integer> generate(List<Integer> a) {
        int n = a.size();
        int dip_index = -1;

        List<Integer> nums = new ArrayList<>(a);

        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                dip_index = i;
                break;
            }
        }

        if (dip_index == -1) {
            Collections.reverse(nums);
            return nums;
        }

        for (int i = n - 1; i > dip_index; i--) {
            if (nums.get(i) > nums.get(dip_index)) {
                int temp = nums.get(i);
                nums.set(i, nums.get(dip_index));
                nums.set(dip_index, temp);
                break;
            }
        }

        reverse(nums, dip_index + 1, n - 1);
        return nums;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> dummy = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            dummy.add(nums[i]);
        }
        ans.add(new ArrayList<>(dummy));
        for (int i = 1; i < factorial(nums.length); i++) {
            dummy = generate(dummy);
            ans.add(new ArrayList<>(dummy));
        }

        return ans;
    }
}
