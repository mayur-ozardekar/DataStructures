//package com.study.ds.arrays;
//
//import javafx.util.Pair;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class IslandProblem {
//
//    /**
//     * You are given an m x n binary matrix grid.
//     * An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
//     * You may assume all four edges of the grid are surrounded by water.
//     *
//     * An island is considered to be the same as another
//     * if and only if one island can be translated (and not rotated or reflected) to equal the other.
//     *
//     * Return the number of distinct islands.
//     *
//     */
//    private int[][] grid;
//    private boolean[][] seen;
//    private Set<Pair<Integer, Integer>> currentIsland;
//    private int currRowOrigin;
//    private int currColOrigin;
//
//    public int numDistinctIslands(int[][] grid) {
//        this.grid = grid;
//        this.seen = new boolean[grid.length][grid[0].length];
//        Set<Set<Pair<Integer, Integer>>> islands = new HashSet<>();
//
//        for (int row = 0; row < grid.length; row++) {
//            for (int col = 0; col < grid[0].length; col++) {
//                this.currentIsland = new HashSet<>();
//                this.currRowOrigin = row;
//                this.currColOrigin = col;
//
//                dfs(row, col);
//
//                if (!currentIsland.isEmpty())
//                    islands.add(currentIsland);
//            }
//        }
//
//        return islands.size();
//    }
//
//    private void dfs(int row, int col) {
//        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
//
//        if (grid[row][col] == 0 || seen[row][col]) return;
//
//        seen[row][col] = true;
//        currentIsland.add(new Pair<>(row - currRowOrigin, col - currColOrigin));
//
//        dfs(row + 1, col);
//        dfs(row - 1, col);
//        dfs(row, col + 1);
//        dfs(row, col - 1);
//    }
//
//    public int maxAreaOfIsland(int[][] grid) {
//
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        int maxArea = 0;
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                maxArea = Math.max(maxArea, traverse(i, j, rows, cols, grid));
//            }
//        }
//
//        return maxArea;
//    }
//
//    public int numIslands(char[][] grid) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        int count = 0;
//
//        for (int row = 0; row < rows; row++) {
//            for (int col = 0; col < cols; col++) {
//                if (grid[row][col] == '1') {
//                    count++;
//                    traverse(grid, row, col, rows, cols);
//                }
//            }
//        }
//
//        return count;
//    }
//
//    public void traverse(char[][] grid, int row, int col, int rows, int cols) {
//        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
//            return;
//        }
//
//        grid[row][col] = '0';
//
//        // right
//        traverse(grid, row + 1, col, rows, cols);
//        // left
//        traverse(grid, row - 1, col, rows, cols);
//        // top
//        traverse(grid, row, col - 1, rows, cols);
//        // bottom
//        traverse(grid, row, col + 1, rows, cols);
//
//    }
//
//    public int traverse(int row, int col, int rows, int cols, int[][] grid) {
//
//        // 1. base condition
//        if (row < 0 || col < 0 || cols <= col || rows <= row || grid[row][col] == -1 || grid[row][col] == 0) {
//            return 0;
//        } else {
//            grid[row][col] = -1;
//
//            return (1
//                    // 2. left
//                    + traverse(row - 1, col, rows, cols, grid)
//                    // 3. right
//                    + traverse(row + 1, col, rows, cols, grid)
//                    // 4. top
//                    + traverse(row, col - 1, rows, cols, grid)
//                    // 5. bottom
//                    + traverse(row, col + 1, rows, cols, grid));
//        }
//
//    }
//}
