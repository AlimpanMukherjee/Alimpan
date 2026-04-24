class Solution {
    public int furthestDistanceFromOrigin(String moves) {

        int n = moves.length();   
        int r = 0, l = 0, g = 0;  

        for (int i = 0; i < n; i++)
        {
            if (moves.charAt(i) == 'R') r++;  
            if (moves.charAt(i) == 'L') l++;   
            if (moves.charAt(i) == '_') g++;   
        }

        return (r > l) ? (r - l + g) : (l -r+ g);
    }
}