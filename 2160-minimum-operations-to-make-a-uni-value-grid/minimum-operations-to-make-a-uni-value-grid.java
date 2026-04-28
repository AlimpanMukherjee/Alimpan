import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int[] g = new int[n * m];
        int k = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[k++] = grid[i][j];
            }
        }

        Arrays.sort(g, 0, n * m);

        int diff;
        for (int i = 1; i < n * m; i++) {
            diff = g[i] - g[i - 1];
            if (diff % x != 0) return -1;
        }

        int[] cal1 = new int[n * m];
        int []cal2=new int[n*m];
        int []cal3=new int[n*m];
        int steps;

        // Front to back
        for (int i = 1; i < n * m; i++) {
            diff = g[i] - g[i - 1];
            steps = diff / x;

            cal1[i] = i * steps + cal1[i - 1];

            System.out.println(cal1[i]);
        }

        // Back to front
        for (int i = n * m - 2; i >= 0; i--) {
            diff = g[i + 1] - g[i];
            steps = diff / x;
            cal2[i]=(n * m - i - 1)*steps + cal2[i + 1];
            System.out.println(cal2[i]);
        }


        for(int i=0;i<n*m;i++)
        {
            cal3[i]=cal1[i]+cal2[i];
        }
        int min = cal3[0];
        

        for (int i = 0; i < n * m; i++) {
            if (cal3[i] < min) min = cal3[i];
        }

        return min;
    }
}