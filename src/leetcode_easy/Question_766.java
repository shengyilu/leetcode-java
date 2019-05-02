package leetcode_easy;

public class Question_766 {

    public boolean isToeplitzMatrix(int[][] matrix) {

        int rows_count = matrix.length;
        int cols_count = matrix[0].length;

        boolean isToeplitz = true;
        for (int i = 0; i < rows_count; i++) {
            if (i + 1 >= rows_count) {
                break;
            }

            int[] row_dominator = matrix[i];
            int dominator = 0;
            for (int j = 0; j < cols_count - 1; j++) {
                dominator = dominator * 10 + row_dominator[j];
            }

            int[] row_comparator = matrix[i + 1];
            int comparator = 0;
            for (int j = 1; j < cols_count; j++) {
                comparator = comparator * 10 + row_comparator[j];
            }

            if (dominator != comparator) {
                isToeplitz = false;
                break;
            }
        }
        return isToeplitz;
    }

    public void solve() {

        int[][] input_matrix = new int[][] {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        };

        int[][] input_matrix2 = new int[][] {
                {1, 2},
                {2, 2}
        };

        System.out.println(isToeplitzMatrix(input_matrix2));
    }

}
