class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Initialize first row and first column
        for (int i = 1; i < Math.max(rows, cols); i++) {
            if (i < cols) grid[0][i] += grid[0][i - 1];  // First row
            if (i < rows) grid[i][0] += grid[i - 1][0];  // First column
        }

        // Compute the min path sum for the rest of the grid
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[rows - 1][cols - 1];
    }
}
