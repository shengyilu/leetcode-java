package leetcode_easy;

import java.util.Arrays;

public class Question_283 {

    public void moveZeroes(int[] nums) {
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                nums[nums.length - 1] = 0;
            }
            if (nums[i] == 0) {
                i--;
            }
            if (zeros == nums.length) {
                break;
            }
        }
    }

    public void solve() {
        int[] input = {0, 0 , 1};
        moveZeroes(input);


    }
}
