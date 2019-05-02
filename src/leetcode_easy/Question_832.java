package leetcode_easy;

import java.util.Arrays;

public class Question_832 {

    public int[][] flipAndInvertImage(int[][] A) {

        for (int[] row : A) {
            for (int i = 0; i < (row.length + 1) / 2; i++) {
                int tmp = row[i] ^ 1;
                System.out.println("row[" + i + "]:" + row[i] + ", tmp:" + tmp);
                row[i] = row[row.length - 1 - i] ^ 1;
                row[row.length - 1 - i] = tmp;
            }
        }

        return A;

    }

    public void solve() {

        int[][] A = new int[][] {
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };

        int[][] B = flipAndInvertImage(A);

        for (int[] row : B) {
            System.out.println(Arrays.toString(row));
        }

    }
}
