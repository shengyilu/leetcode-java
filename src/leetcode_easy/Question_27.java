package leetcode_easy;

import java.util.Arrays;

public class Question_27 {


    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int redundantCount = 0;
        int index = 0;

        while (index < len - redundantCount) {
            if (nums[index] == val) {
                int temp = nums[index];
                nums[index] = nums[len - redundantCount - 1];
                nums[len - redundantCount - 1] = temp;
                redundantCount++;
            } else {
                index++;
            }
        }
        return len - redundantCount;
    }

    public void solve() {
        int[] input = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(input, 2));
        System.out.println(Arrays.toString(input));
    }
}
