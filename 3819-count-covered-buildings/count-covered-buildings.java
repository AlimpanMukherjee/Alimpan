import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        Map<Integer, TreeSet<Integer>> rowToCols = new HashMap<>();
        Map<Integer, TreeSet<Integer>> colToRows = new HashMap<>();

        // Storing row and column values separately and populating the maps
        for (int[] building : buildings) {
            int r = building[0];
            int c = building[1];
            rows.add(r);
            cols.add(c);
            rowToCols.computeIfAbsent(r, k -> new TreeSet<>()).add(c);
            colToRows.computeIfAbsent(c, k -> new TreeSet<>()).add(r);
        }

        int rowmin = Collections.min(rows);
        int rowmax = Collections.max(rows);
        int colmin = Collections.min(cols);
        int colmax = Collections.max(cols);

        int count = 0;

        for (int i = 0; i < rows.size(); i++) {  
            int rowcurr = rows.get(i);  
            int colcurr = cols.get(i);

            
            if (rowcurr > rowmin && rowcurr < rowmax && colcurr > colmin && colcurr < colmax) {
                
                boolean u = false, d = false, l = false, r = false;

                
                Integer up = colToRows.get(colcurr).lower(rowcurr);
                if (up != null) u = true;

                
                Integer down = colToRows.get(colcurr).higher(rowcurr);
                if (down != null) d = true;

                
                Integer left = rowToCols.get(rowcurr).lower(colcurr);
                if (left != null) l = true;

                
                Integer right = rowToCols.get(rowcurr).higher(colcurr);
                if (right != null) r = true;

                
                if (u && d && l && r) {
                    count++;
                }
            }
        }

        return count;
    }
}
