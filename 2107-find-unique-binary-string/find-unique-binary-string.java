class Solution {
    String ans = "";

    public void generate(char[] a,int i, int n, List<Character> ls, HashSet<String> set) {
        if (ls.size() == n) {
            StringBuilder s = new StringBuilder();
            for (char c : ls) {
                s.append(c);
            }

            if (set.contains(s.toString())) return;
            else {
                ans = s.toString();
                return;
            }
        }

        //for (int i = 0; i < 2; i++) {
            if(i<2){
            ls.add(a[i]);
            generate(a, i , n, ls, set);
            ls.remove(ls.size() - 1);
            generate(a, i+1 , n, ls, set);
            }
        //}
    }

    public String findDifferentBinaryString(String[] nums) {
        char[] a = new char[2];
        a[0] = '0';
        a[1] = '1';

        int n = nums.length;

        List<Character> ls = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for (String s : nums) {
            set.add(s);
        }

        generate(a, 0, n, ls, set);

        return ans;
    }
}
