package leetcode_easy;

import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int[] answer = new int[2];

        int left = 0;
        int right = copy.length - 1;

        int leftValue = 0;
        int rightValue = 0;

        while (left < right) {
            leftValue = copy[left];
            rightValue = copy[right];

            if (leftValue + rightValue < target) {
                left++;
            } else if (leftValue + rightValue > target) {
                right--;
            } else {
                break;
            }

            if (left > 0 && copy[left] == copy[left-1]) {
                left++;
            }

            if (right < copy.length - 1 && copy[right] == copy[right+1]) {
                right--;
            }
        }

        int answerIndex = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == leftValue || nums[index] == rightValue) {
                answer[answerIndex] = index;
                answerIndex++;
                if (answerIndex > 1) {
                    break;
                }
            }
        }
        return answer;
    }

    public void solve() {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;

        int[] answer = twoSum(nums, target);


        System.out.println("Answer:" + Arrays.toString(answer));

    }
}
