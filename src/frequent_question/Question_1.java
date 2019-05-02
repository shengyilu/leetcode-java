package frequent_question;

import java.util.Arrays;

/*
* 1. Two Sum
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
  You may assume that each input would have exactly one solution, and you may not use the same element twice.

  Example:
  Given nums = [2, 7, 11, 15], target = 9,
  Because nums[0] + nums[1] = 2 + 7 = 9,
  return [0, 1].
*
* */
public class Question_1 {

    public int[] twoSum(int[] nums, int target) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            if (sortedNums[leftIndex] + sortedNums[rightIndex] < target) {
                leftIndex++;
            } else if (sortedNums[leftIndex] + sortedNums[rightIndex] > target) {
                rightIndex--;
            } else {
                break;
            }

            if (leftIndex > 0 && sortedNums[leftIndex] == sortedNums[leftIndex - 1]) {
                leftIndex++;
            }

            if (rightIndex < nums.length - 1 && sortedNums[rightIndex] == sortedNums[rightIndex + 1]) {
                rightIndex--;
            }
        }

        int[] answer = new int[2];
        int answerIndex = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == sortedNums[leftIndex] || nums[index] == sortedNums[rightIndex]) {
                answer[answerIndex] = index;
                answerIndex++;
                if (answerIndex > 1) {
                    break;
                }
            }
        }

        return answer;
    }



}
