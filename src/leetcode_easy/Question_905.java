package leetcode_easy;

import java.util.Arrays;

public class Question_905 {

    public int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];

        int evenIndex = 0;
        int oddIndex = A.length - 1;
        for (int value : A) {
            if (value % 2 == 0) {
                B[evenIndex] = value;
                evenIndex++;
            } else {
                B[oddIndex] = value;
                oddIndex--;
            }
        }
        return B;
    }

    public void solve() {

        int[] input = new int[] { 3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity(input)));
    }
}
