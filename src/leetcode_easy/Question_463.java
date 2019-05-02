package leetcode_easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question_463 {

    private int[][] direction = new int[][] {
            {  1,  0}, // down
            {  0,  1}, // right
            { -1,  0}, // up
            {  0, -1}   // left
    };

    private Set<Integer> walkedPath = new HashSet<>();

    private int dfs(int[][] grid, int oldpos, int row, int col) {

        if (row < 0 || row >= grid.length) {
            return 1;
        }

        if (col < 0 || col >= grid[0].length) {
            return 1;
        }

        if (grid[row][col] == 0) {
            return 1;
        }

        int pos = row * grid[0].length + col;
        //System.out.println("pos:" + pos);
        walkedPath.add(pos);

        int count = 0;
        for (int[] next : direction) {
            int nextRow = row + next[0];
            int nextCol = col + next[1];

            int nextPos = nextRow * grid[0].length + nextCol;
            if (oldpos == nextPos) {
                continue;
            }
            //System.out.println("nextPos:" + nextPos);
            if (!walkedPath.contains(nextPos)) {
                int num = dfs(grid, pos, nextRow, nextCol);
                count += num;
            }
        }

        return count;
    }

    public int islandPerimeter(int[][] grid) {
        int col = 0, row = 0;
        boolean found = false;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    col = c;
                    row = r;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        int count = dfs(grid, row * grid[0].length + col, row, col);
        System.out.println("count:" + count);
        return count;
    }

    public void solve() {

        int test = 1;
        int test_shift = test << 4;

        System.out.println(test + ", " + test_shift);

        int[][] input = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        int[][] input2 = new int[][]{
                {0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,1,0,1,1,0},
                {0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,1,0,0,1,0},
                {0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,1,0},
                {0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
                {1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
                {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
                {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
                {0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
                {0,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
                {0,0,1,1,1,0,1,1,1,1,1,1,0,0,1,1,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0},
                {0,0,1,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0} };

        int[][] input3 = new int[][]{
                {0,0,0,0,0,0,0,0,1,1,1,0,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0},
                };


        islandPerimeter(input);


    }
}
