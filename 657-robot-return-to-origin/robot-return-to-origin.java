class Solution {
    public boolean judgeCircle(String moves) {
        int vertical = 0;
        int horizontal = 0;

        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            if (move == 'U') {
                vertical++;
            } else if (move == 'D') {
                vertical--;
            } else if (move == 'L') {
                horizontal++;
            } else if (move == 'R') {
                horizontal--;
            }
        }

        return vertical == 0 && horizontal == 0;
    }
}
