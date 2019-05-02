package frequent_question;

/*
* 15. 3Sum
*
* Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
* Find all unique triplets in the array which gives the sum of zero.
Note:
The solution set must not contain duplicate triplets.
Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_15 {

    public List<List<Integer>> twoSum(int[] nums, int target, int offset) {
        System.out.println("Targer:" + target);
        List<List<Integer>> answer = new ArrayList<>();

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            if (leftIndex == offset) {
                leftIndex++;
                continue;
            } else if (rightIndex == offset) {
                rightIndex--;
                continue;
            }

            if (nums[leftIndex] + nums[rightIndex] < target) {
                leftIndex++;
            } else if (nums[leftIndex] + nums[rightIndex] > target) {
                rightIndex--;
            } else {
                List<Integer> twoSum = new ArrayList<>();
                twoSum.add(nums[leftIndex]);
                twoSum.add(nums[rightIndex]);
                answer.add(twoSum);
                System.out.println(Arrays.toString(twoSum.toArray()));
                break;
            }

            if (leftIndex > 0 && nums[leftIndex] == nums[leftIndex - 1]) {
                leftIndex++;
            }

            if (rightIndex < nums.length - 1 && nums[rightIndex] == nums[rightIndex + 1]) {
                rightIndex--;
            }
        }


        return answer;
    }


    public List<List<Integer>> threeSum(int[] nums, int target, int offset) {

        List<List<Integer>> result = new ArrayList<>();
        while (offset < nums.length) {
            if (offset > 0 && nums[offset] == nums[offset - 1]) {
                offset++;
                continue;
            }
            System.out.println("nums[offset]:" + nums[offset]);
            int findTarget = target - nums[offset];
            List<List<Integer>> twoSums = twoSum(nums, findTarget, offset);
            for (List<Integer> twoSum : twoSums) {
                twoSum.add(nums[offset]);
                result.add(twoSum);
            }

            offset++;
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        List<List<Integer>> answers = threeSum(nums, 0, 0);

        return answers;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public void solve() {
        int[] input = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> results = threeSum(input);
        for (List<Integer> result : results) {
            System.out.println(Arrays.toString(result.toArray()));
        }

    }

}
