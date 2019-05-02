package leetcode_easy;

public class Question_896 {


    public boolean isMonotonic(int[] A) {

        boolean isMonotonic = true;
        int expectedSlope = 0;

        for (int i = 0; i < A.length - 1; i = i+1) {
            int slope = 0;
            if (A[i] != A[i + 1]) {
                slope = (A[i] > A[i + 1]) ? -1 : 1;
            }

            if (expectedSlope == 0 && slope != 0) {
                expectedSlope = slope;
            }

            if (slope * expectedSlope < 0) {
                isMonotonic = false;
                break;
            }
        }
        return isMonotonic;
    }

    public void solve() {
        int[] A = {1, 3, 2};
        System.out.println(isMonotonic(A));

    }
}
