class Solution {
    public String reverseWords(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ((st.isEmpty() || st.peek() == ' ') && s.charAt(i) == ' ')
                continue;
            else
                st.push(s.charAt(i));
        }

        while (!st.isEmpty() && st.peek() == ' ')
            st.pop();

        StringBuilder str = new StringBuilder();
        Stack<Character> stn = new Stack<>();

        while (!st.isEmpty()) {
            char element = st.pop();
            if (element != ' ') {
                stn.push(element);
            }
            if (element == ' ') {
                while (!stn.isEmpty())
                    str.append(stn.pop());
                str.append(' ');
            }
        }

        while (!stn.isEmpty())
            str.append(stn.pop());

        return str.toString();
    }
}
