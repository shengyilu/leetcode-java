package leetcode_easy;

import java.util.HashMap;

public class Question_169 {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int majorityElementLenth = 0;
        int majorityElement = 0;
        for (int val : nums) {
            int count;
            if (map.containsKey(val)) {
                count = map.get(val);
                map.put(val, count + 1);
                count++;
            } else {
                map.put(val, 1);
                count = 1;
            }
            if (majorityElementLenth < count) {
                majorityElementLenth = count;
            }
            if (majorityElementLenth > nums.length / 2) {
                return val;
            }
        }
        return majorityElement;
    }

    public void solve() {
        int[] input = {1};
        System.out.println(majorityElement(input));
    }
}
