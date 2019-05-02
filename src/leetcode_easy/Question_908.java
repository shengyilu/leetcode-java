package leetcode_easy;

import java.util.Arrays;

public class Question_908 {

    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        int min = A[0];
        int min_max = min + K;
        int max = A[A.length - 1];
        int max_min = max - K;

        int range = 0;
        if (min_max >= max_min) {
            range = 0;
        } else {
            range = max_min - min_max;
        }
        return range;
    }

    public void solve() {
        int[] A = new int[] {0,10};
        int K = 2;
        System.out.println(smallestRangeI(A,K));

    }
}
