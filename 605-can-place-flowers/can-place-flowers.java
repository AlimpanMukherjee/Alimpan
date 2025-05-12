class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int c = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0) {
                if (flowerbed[i] == 0 && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)) {
                    flowerbed[0] = 1;
                    c++;
                }
            } else if (i == flowerbed.length - 1) {  
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    c++;
                }
            } else {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    c++;
                }
            }
        }

        if (c >= n) {
            return true;
        }
        return false;
    }
}
