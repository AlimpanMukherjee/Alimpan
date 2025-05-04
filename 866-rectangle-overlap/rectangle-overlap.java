class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int ax1=rec1[0];
        int ax2=rec1[2];
        int ay1=rec1[1];
        int ay2=rec1[3];

        int bx1=rec2[0];
        int bx2=rec2[2];
        int by1=rec2[1];
        int by2=rec2[3];


        int firstTotal = Math.abs((ax2 - ax1) * (ay2 - ay1));
        int secondTotal = Math.abs((bx2 - bx1) * (by2 - by1));
        int thirdTotal = 0;

        int k1 = Math.abs((ax2 - ax1) + (bx2 - bx1));
        int k2 = Math.abs(Math.max(bx2, ax2) - Math.min(ax1, bx1));

        int l1 = Math.abs((ay2 - ay1) + (by2 - by1));
        int l2 = Math.abs(Math.max(ay2, by2) - Math.min(ay1, by1));

        if (k1 > k2 && l1 > l2) { // overlap detected
            int k3 = k1 - k2;
            int l3 = l1 - l2;
            thirdTotal = k3 * l3;
        }

        if(thirdTotal==0)
        {
            return false;
        }
        else
        {
            return true;
        }
        // return firstTotal + secondTotal - thirdTotal;
    }
}