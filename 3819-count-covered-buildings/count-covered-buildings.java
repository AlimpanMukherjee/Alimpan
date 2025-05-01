// import java.util.*;

// class Solution {
//     public int countCoveredBuildings(int n, int[][] buildings) {
//         List<Integer> rows = new ArrayList<>();
//         List<Integer> cols = new ArrayList<>();

//         Map<Integer, TreeSet<Integer>> rowToCols = new HashMap<>();
//         Map<Integer, TreeSet<Integer>> colToRows = new HashMap<>();

//         // Storing row and column values separately and populating the maps
//         for (int[] building : buildings) {
//             int r = building[0];
//             int c = building[1];
//             rows.add(r);
//             cols.add(c);
//             rowToCols.computeIfAbsent(r, k -> new TreeSet<>()).add(c);
//             colToRows.computeIfAbsent(c, k -> new TreeSet<>()).add(r);
//         }

//         int rowmin = Collections.min(rows);
//         int rowmax = Collections.max(rows);
//         int colmin = Collections.min(cols);
//         int colmax = Collections.max(cols);

//         int count = 0;

//         for (int i = 0; i < rows.size(); i++) {  
//             int rowcurr = rows.get(i);  
//             int colcurr = cols.get(i);

            
//             if (rowcurr > rowmin && rowcurr < rowmax && colcurr > colmin && colcurr < colmax) {
                
//                 boolean u = false, d = false, l = false, r = false;

                
//                 Integer up = colToRows.get(colcurr).lower(rowcurr);
//                 if (up != null) u = true;

                
//                 Integer down = colToRows.get(colcurr).higher(rowcurr);
//                 if (down != null) d = true;

                
//                 Integer left = rowToCols.get(rowcurr).lower(colcurr);
//                 if (left != null) l = true;

                
//                 Integer right = rowToCols.get(rowcurr).higher(colcurr);
//                 if (right != null) r = true;

                
//                 if (u && d && l && r) {
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }
// }
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] rowMin = new int[n + 1];
        Arrays.fill(rowMin, n + 1);
        int[] rowMax = new int[n + 1];
        // Arrays.fill(rowMax, 0);

        int[] colMin = new int[n + 1];
        Arrays.fill(colMin, n + 1);
        int[] colMax = new int[n + 1];
        // Arrays.fill(colMax, 0);
        int x = 0, y = 0;
        for (int[] item: buildings) {
            x = item[0];
            y = item[1];
            rowMin[y] = Math.min(rowMin[y], x);
            rowMax[y] = Math.max(rowMax[y], x);

            colMin[x] = Math.min(colMin[x], y);
            colMax[x] = Math.max(colMax[x], y);
        }

        int ans = 0;

        for (int[] item: buildings) {
            x = item[0];
            y = item[1];
            if (x > rowMin[y] && x < rowMax[y] && y > colMin[x] && y < colMax[x]) {
                ans += 1;
            }
        }

        return ans;
    }
}
