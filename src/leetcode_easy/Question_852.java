package leetcode_easy;

import java.util.Arrays;

public class Question_852 {


    private int findPeak(int[] A, int leftBound, int rightBound) {
        int half = (rightBound - leftBound + 1) / 2;

        int middle_index = half + leftBound;
        int slope_left = A[middle_index] - A[middle_index-1];
        int slope_right = A[middle_index] - A[middle_index+1];

        if (slope_left > 0 && slope_right > 0) {
            return middle_index;
        } else {
            if (slope_left < 0) {
                return findPeak(A, leftBound, middle_index);
            } else {
                return findPeak(A, middle_index, rightBound);
            }
        }
    }

    public int peakIndexInMountainArray(int[] A) {
        return findPeak(A, 0, A.length -1);
    }

    public void solve() {
        int[] mountain = new int[] {0,1,3,4,1};
        System.out.println(peakIndexInMountainArray(mountain));
    }
}
