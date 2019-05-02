package leetcode_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Question_594 {

    public int findLHS(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int val : nums) {
            if (map.containsKey(val)) {
                int count = map.get(val);
                map.put(val, count + 1);
            } else {
                map.put(val, 1);
                list.add(val);
            }
        }
        int maxLen = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (Math.abs(list.get(i + 1) - list.get(i))== 1) {

                int len = map.get(list.get(i + 1)) + map.get(list.get(i));
                if (maxLen < len) {
                    maxLen = len;
                }
            }
        }
        return maxLen;

    }

    public void solve() {
        int[] input = {-1, 0,-1,0,-1,0,-1};
        System.out.println(findLHS(input));
    }

}
