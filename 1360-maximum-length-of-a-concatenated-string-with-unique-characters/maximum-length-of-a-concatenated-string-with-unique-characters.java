class Solution {
    int max = 0;
    List<String> arr;
    int n;

    public boolean checkDup(List<String> ls) {
        StringBuilder newstring = new StringBuilder();
        for (String s : ls) {
            newstring.append(s);
        }

        HashSet<Character> set = new HashSet<>();
        for (char c : newstring.toString().toCharArray()) {
            if (set.contains(c)) return true;
            set.add(c);
        }
        return false;
    }

    public void generate(int index, List<String> ls) {
        if (index == n) {
            if (!checkDup(ls)) {
                int totalLen = 0;
                for (String s : ls) totalLen += s.length();
                max = Math.max(max, totalLen);
            }
            return;
        }

        ls.add(arr.get(index));
        generate(index + 1, ls);
        ls.remove(ls.size() - 1);
        generate(index + 1, ls);
    }

    public int maxLength(List<String> arr) {
        this.arr = arr;
        this.n = arr.size();
        List<String> ls = new ArrayList<>();
        generate(0, ls);
        return max;
    }
}
