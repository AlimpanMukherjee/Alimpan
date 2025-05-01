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

        // Checking each building
        for (int i = 0; i < rows.size(); i++) {  
            int rowcurr = rows.get(i);  
            int colcurr = cols.get(i);

            // Ensure the building is not on the boundary
            if (rowcurr > rowmin && rowcurr < rowmax && colcurr > colmin && colcurr < colmax) {
                // Use TreeSet to check for neighbors efficiently
                boolean u = false, d = false, l = false, r = false;

                // Up: is there a row < rowcurr at colcurr?
                Integer up = colToRows.get(colcurr).lower(rowcurr);
                if (up != null) u = true;

                // Down: is there a row > rowcurr at colcurr?
                Integer down = colToRows.get(colcurr).higher(rowcurr);
                if (down != null) d = true;

                // Left: is there a col < colcurr at rowcurr?
                Integer left = rowToCols.get(rowcurr).lower(colcurr);
                if (left != null) l = true;

                // Right: is there a col > colcurr at rowcurr?
                Integer right = rowToCols.get(rowcurr).higher(colcurr);
                if (right != null) r = true;

                // If building is surrounded in all 4 directions
                if (u && d && l && r) {
                    count++;
                }
            }
        }

        return count;
    }
}
