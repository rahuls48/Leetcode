// Problem: Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.

// Approach 1: Brute Force Solution
// We can iterate over every cell in the grid and if we encounter a land cell ('1'), we can do a depth-first search to mark all the cells in the same island as visited. Then we can count the number of islands that we have encountered by simply counting the number of depth-first searches that we have performed.
// Time Complexity: O(m*n * max(m, n))
// Space Complexity: O(m*n)
public int numIslands(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    int count = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == '1' && !visited[i][j]) {
                dfs(grid, visited, i, j);
                count++;
            }
        }
    }
    return count;
}

private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) {
        return;
    }
    visited[i][j] = true;
    dfs(grid, visited, i + 1, j);
    dfs(grid, visited, i - 1, j);
    dfs(grid, visited, i, j + 1);
    dfs(grid, visited, i, j - 1);
}

// Approach 2: Optimized DFS Solution
// In the previous approach, we were doing a depth-first search on every cell that we encountered, 
//even if it had already been visited before. We can optimize this approach by only doing a depth-first 
//search on cells that haven't been visited before and are land cells ('1').
// Time Complexity: O(m*n)
// Space Complexity: O(m*n)
public int numIslands(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    int count = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == '1' && !visited[i][j]) {
                dfs(grid, visited, i, j);
                count++;
            }
        }
    }
    return count;
}
