package leetcode_easy;

import java.util.Arrays;

public class Question_561 {

    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }

        return sum;
    }

    public void solve() {
        int[] input = new int[]{1, 4, 3, 2};
        System.out.println(arrayPairSum(input));
    }
}
