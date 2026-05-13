import java.util.Stack;

class Pair
{
    char c;
    int idx;

    Pair(char c, int idx)
    {
        this.c = c;
        this.idx = idx;
    }
}

class Solution {
    public int minAddToMakeValid(String s) {

        Stack<Pair> st = new Stack<>();

        int valid[] = new int[s.length()];
        int n = s.length();

        int i = 0;

        // prevent index out of bounds
        while (i < n && s.charAt(i) != '(')
        {
            i++;
        }

        // if no '(' exists
        if (i == n)
        {
            return n;
        }

        st.push(new Pair('(', i));

        for (int j = i + 1; j < n; j++)
        {
            if (s.charAt(j) == '(')
            {
                st.push(new Pair('(', j));
            }
            else
            {
                if (!st.isEmpty() && st.peek().c == '(')
                {
                    int id = st.pop().idx;

                    valid[id] = 1;
                    valid[j] = 1;
                }
            }
        }

        int count = 0;

        for (int j = 0; j < n; j++)
        {
            if (valid[j] == 0)
            {
                count++;
            }
        }

        return count;
    }
}