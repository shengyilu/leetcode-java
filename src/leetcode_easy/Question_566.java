package leetcode_easy;

import java.util.Arrays;

public class Question_566 {


    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;

        if (row * col != r * c) {
            return nums;
        }
        int[] flat = new int[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                flat[i * col + j] = nums[i][j];
            }
        }

        int[][] reshape = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reshape[i][j] = flat[i * c + j];
            }
        }

        return reshape;
    }

    public void solve() {
        int[][] input = {
                {1,2},
                {3,4}
        };

        int[][] result = matrixReshape(input, 1, 4);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }

    }
}
