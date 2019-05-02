package leetcode;

public class MedianOfTwoSortedArray_4 {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int short_length = nums1.length;
        int long_length = nums2.length;


        if (short_length > long_length) {
            int[] temp = nums1;
            nums1= nums2;
            nums2 = temp;
            short_length = nums1.length;
            long_length = nums2.length;
        }

        int iMin = 0;
        int iMax = short_length;
        int half = (short_length + long_length + 1) / 2;

        while (iMin <= iMax) {

            int i = (iMax + iMin) / 2;
            int j = half - i;

            if (i < iMax && nums1[i-1] > nums2[j]) {
                iMax = i - 1;
            } else if (i > iMin && nums1[i] < nums2[j-1]) {
                iMin = i + 1;
            } else {
                int leftMax = 0;
                if (i == 0) {
                    leftMax = nums2[j-1];
                } else if (j == 0) {
                    leftMax = nums1[i-1];
                } else {
                    leftMax = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ( (short_length + long_length) % 2 == 1 ) { return leftMax; }

                int rightMin = 0;
                if (i == short_length) {
                    rightMin = nums2[j];
                } else if (j == long_length) {
                    leftMax = nums1[i];
                } else {
                    leftMax = Math.max(nums1[i], nums2[j]);
                }
                return (leftMax + rightMin) / 2.0;
            }
        }
        return 0.0;

    }

    public void solve() {
        int[] nums1 = new int[]{2, 8, 12, 13, 28, 33, 37};
        int[] nums2 = new int[]{1, 4, 20, 23, 31, 35, 40, 42};

        double median = findMedianSortedArrays(nums1, nums2);

        System.out.println("median:" + median);

    }

}
