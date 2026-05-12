class Pair {
    int idx;
    char c;

    Pair(int idx, char c) {
        this.idx = idx;
        this.c = c;
    }
}

class Solution {

    public int longestValidParentheses(String s) {

        Stack<Pair> st = new Stack<Pair>();

        int n = s.length();
        int i = 0;

        int[] arr = new int[s.length()];

        while(i < s.length() && s.charAt(i) != '(') {
            i++;
            continue;
        }

        if(i >= n - 1) return 0;

        st.push(new Pair(i, s.charAt(i)));

        int count = 0;
        int maxcount = 0;

        for(int j = i + 1; j < n; j++) {

            if(s.charAt(j) == '(') {

                st.push(new Pair(j, '('));
            }

            else if(s.charAt(j) == ')') {

                if(!st.isEmpty() && st.peek().c == '(') {

                    arr[j] = 1;

                    int k = st.pop().idx;

                    arr[k] = 1;
                }

                else {

                    st.clear();

                    count = 0;
                }
            }
        }

        for(i = 0; i < n; i++) {

            if(arr[i] == 1) {

                count++;

                maxcount = Math.max(maxcount, count);
            }

            else {
                count = 0;
            }
        }

        return maxcount;
    }
}