public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Mark the 'O's connected to the borders
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[rows - 1][j] == 'O') dfs(board, rows - 1, j);
        }

        // Step 2: Flip all 'O's to 'X's, and all '*'s back to 'O's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;

        // Boundary check
        if (row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != 'O') {
            return;
        }

        // Mark the cell as visited by setting it to '*'
        board[row][col] = '*';

        // Visit all four neighbors (up, down, left, right)
        dfs(board, row - 1, col); // up
        dfs(board, row + 1, col); // down
        dfs(board, row, col - 1); // left
        dfs(board, row, col + 1); // right
    }

    public static void main(String[] args) {
        SurroundedRegions solution = new SurroundedRegions();
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        solution.solve(board);
        for (char[] row : board) {
            System.out.println(new String(row));
        }
        // Output should be:
        // X X X X
        // X X X X
        // X X X X
        // X O X X
    }
}
