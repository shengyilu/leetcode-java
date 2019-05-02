package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public List<List<Integer>> nSum(int[] nums, int target, int nplets, int offset) {
        List<List<Integer>> result = new ArrayList<>();
        if (nplets == 2) {

            int left = offset;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum <  target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    List<Integer> duplets = new ArrayList<>();
                    duplets.add(nums[left]);
                    duplets.add(nums[right]);

                    result.add(duplets);
                    left++;
                    right--;
                }

                while (left > offset && left < nums.length && nums[left] == nums[left-1]) {
                    left++;
                }

                while (right < nums.length -1 && right > offset && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
            return result;
        }

        for (int index = offset; index < nums.length; index++) {
            if (index > offset && nums[index] == nums[index - 1]) {
                continue;
            }
            int newTarget = target - nums[index];
            int newN = nplets - 1;
            List<List<Integer>> k1Sum = nSum(nums, newTarget, newN, index + 1);
            for (List<Integer> k1 : k1Sum) {
                k1.add(nums[index]);
                result.add(k1);
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println("nums:" + Arrays.toString(nums));
        return nSum(nums, 0, 3, 0);
    }

    public void solve() {
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        int target = 0;

        //Arrays.sort(nums);

        List<List<Integer>> answers = threeSum(nums);

        for (List<Integer> temp : answers) {
            System.out.println("Answer:" + Arrays.toString(temp.toArray()));
        }

    }

}
