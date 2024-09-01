public class MaxAreaOfIslands {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Boundary check and whether it's water ('0')
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0) {
            return 0;
        }

        // Mark the cell as visited by setting it to '0' (water)
        grid[row][col] = 0;

        // Calculate the area by visiting all four neighbors (up, down, left, right)
        int area = 1; // Current cell
        area += dfs(grid, row - 1, col); // up
        area += dfs(grid, row + 1, col); // down
        area += dfs(grid, row, col - 1); // left
        area += dfs(grid, row, col + 1); // right

        return area;
    }

    public static void main(String[] args) {
        MaxAreaOfIslands solution = new MaxAreaOfIslands();
        int[][] grid = {
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0}
        };
        System.out.println("Max Area of Island: " + solution.maxAreaOfIsland(grid)); // Output: 6
    }
}
