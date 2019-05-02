package leetcode;

import java.util.*;

public class FourSum_18 {

    private List<List<Integer>> nSum(int[] nums, int target, int nplets, int offset) {
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

    public List<List<Integer>> fourSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        //System.out.println("nums:" + Arrays.toString(numbers));
        return nSum(numbers, target, 4, 0);
    }

    public void solve() {
//        int[] nums = new int[] {1, 0, -1, 0, -2, 2};
//        int target = 0;
        int[]  nums = new int[] {-493,-482,-482,-456,-427,-405,-392,-385,-351,-269,-259,-251,-235,-235,-202,-201,-194,-189,-187,-186,-180,-177,-175,-156,-150,-147,-140,-122,-112,-112,-105,-98,-49,-38,-35,-34,-18,20,52,53,57,76,124,126,128,132,142,147,157,180,207,227,274,296,311,334,336,337,339,349,354,363,372,378,383,413,431,471,474,481,492};
        int target = 6189;

        //Arrays.sort(nums);
        long startTime = System.nanoTime();
        List<List<Integer>> answers = fourSum(nums, target);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time:" + duration/1000000);

        for (List<Integer> temp : answers) {
            System.out.println("Answer:" + Arrays.toString(temp.toArray()));
        }

    }

}
