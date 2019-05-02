package leetcode_easy;

import java.util.Arrays;
import java.util.HashMap;

public class Question_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {

            if (i + 1 == nums2.length) {
                map.put(nums2[i], -1);
                break;
            }

            if (nums2[i] < nums2[i + 1]) {
                map.put(nums2[i], nums2[i + 1]);
            } else {
                map.put(nums2[i], -1);
            }
        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    public void solve() {
        int nums1[] = {2, 4};
        int nums2[] = {1, 2, 3, 4};


        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}
