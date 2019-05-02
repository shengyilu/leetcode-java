package leetcode_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            while (val != nums[val - 1]) {
                int temp = nums[val - 1];
                nums[val - 1] = val;
                val = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                result.add(i+1);
            }
        }

        return result;
    }

    public void solve() {
        int[] nums = {4,3,2,7,8,2,3,8};
        System.out.println(findDisappearedNumbers(nums));
    }
}
