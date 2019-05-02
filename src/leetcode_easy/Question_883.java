package leetcode_easy;

import java.util.Arrays;

public class Question_883 {

    public int projectionArea(int[][] grid) {
        int cols_num = grid.length;
        int rows_num = grid[0].length;

        int[] cols_bucket = new int[cols_num];
        int[] rows_bucket = new int[rows_num];
        int row_index = 0;

        int xy = 0;
        for (int j = 0; j < rows_num; j++) {
            // XY projection
            int[] row = grid[j];

            int row_max = 0;
            for (int i = 0; i < row.length; i++) {
                if (row[i] > 0) {
                    xy++;
                }

                // XZ projection
                if (cols_bucket[i] < row[i]) {
                    cols_bucket[i] = row[i];
                }
                // YZ projection
                if (row_max < row[i]) {
                    row_max = row[i];
                }
            }
            rows_bucket[row_index] = row_max;
            row_index++;
        }

        int xz = 0;
        for (int val : cols_bucket) {
            xz += val;
        }

        int yz = 0;
        for (int val : rows_bucket) {
            yz += val;
        }
        return xy + yz + xz;
    }

    public void solve() {
        int[][] input = new int[][]{
                {1,2},
                {3,4}
        };

        System.out.println(projectionArea(input));

    }
}
