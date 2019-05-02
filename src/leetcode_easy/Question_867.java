package leetcode_easy;

import java.util.Arrays;

public class Question_867 {


    public int[][] transpose(int[][] A) {
        int row_num = A.length;
        int col_num = A[0].length;

        int t_row_num = col_num;
        int t_col_num = row_num;
        int[][] AT = new int[t_row_num][t_col_num];

        int current_col = 0;
        for (int[] row : A) {
            for (int t_row = 0; t_row < t_row_num; t_row++) {
                AT[t_row][current_col] = row[t_row];
            }
            current_col++;
        }

        return AT;
    }

    public void solve() {
        int[][] input = new int[][] {
                {1,2,3},
                {4,5,6},
        };

        for (int[] row : transpose(input)) {
            System.out.println(Arrays.toString(row));
        }

    }
}
