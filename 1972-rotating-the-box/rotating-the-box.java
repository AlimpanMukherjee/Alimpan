class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid[0].length;
        int m = boxGrid.length;
        
        char[][] a = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[j][i] = boxGrid[i][j];
            }
        }

        for (int j = 0; j < m; j++) {
            int[] lastblank = new int[2];
            lastblank[0] = -1;
            lastblank[1] = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (a[i][j] == '.') {
                    if (lastblank[0] != -1) continue;
                    lastblank[0] = i;
                    lastblank[1] = j;
                } else if (a[i][j] == '*') {
                    lastblank[0] = -1;
                    lastblank[1] = -1;
                } else {
                    if (lastblank[0] != -1) {
                        a[i][j] = '.';
                        a[lastblank[0]][lastblank[1]] = '#';
                        lastblank[0] = lastblank[0] - 1;
                        lastblank[1] = j;
                    }
                }
            }
        }
        
        for(int i=0;i<n;i++)
        {
            int left=0;
            int right=m-1;
            while(left<right)
            {
                char x=a[i][left];
                a[i][left]=a[i][right];
                a[i][right]=x;
                left++;
                right--;
            }
        }
        
        return a;
    }
}