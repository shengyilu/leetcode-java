package leetcode_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_892 {


    public int surfaceArea(int[][] grid) {

        int zeros = 0;
        List<int[]> localMinimum = new ArrayList<>();
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            int[] row = grid[r];
            int rowMaxvalue = 0;
            for (int c = 0; c < grid[0].length; c++) {
                if (colMax[c] < row[c]) {
                    colMax[c] = row[c];
                }
                if (grid[r][c] == 0) {
                    zeros++;
                }
                if (c > 0  && c < grid[0].length-1 && grid[r][c - 1] > grid[r][c] && grid[r][c + 1] > grid[r][c]) {
                    int[] pos = {r, c};
                    localMinimum.add(pos);
                }
                if (rowMaxvalue < row[c]) {
                    rowMaxvalue = row[c];
                }
            }

            rowMax[r] = rowMaxvalue;
        }
        // Up / Bottom
        int upBottomArea = 2 * grid.length * grid[0].length - 2 * zeros;

        // xz projection area
        int xzProjectionArea = 0;
        for (int value : colMax) {
            xzProjectionArea += value;
        }
        xzProjectionArea *= 2;

        // yz projection area
        int yzProjectionArea = 0;
        for (int value : rowMax) {
            yzProjectionArea += value;
        }
        yzProjectionArea *= 2;

        int zeros_area = 0;
        for (int[] pos : localMinimum) {
            int r = pos[0];
            int c = pos[1];
            int xz_zeros = 0;
            if (r > 0 && r < grid.length - 1) {
                xz_zeros = Math.min(grid[r - 1][c] - grid[r][c], grid[r + 1][c] - grid[r][c]);
            }
            int yz_zeros = Math.min(grid[r][c-1] - grid[r][c], grid[r][c+1] - grid[r][c]);
            zeros_area = 2 * (xz_zeros + yz_zeros);
            System.out.println("zeros_area:" + zeros_area);
        }

        return upBottomArea + yzProjectionArea + xzProjectionArea + zeros_area;
    }

    public void solve() {

        int[][] grid = {
                {4,0,2},
                {1,2,3},
                {2,3,5}
        };

        int[][] grid2 = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };

        System.out.println(surfaceArea(grid2));
    }
}
