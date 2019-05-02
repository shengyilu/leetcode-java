package leetcode_easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Question_136 {


    HashSet<Integer> set = new HashSet<>();

    public int singleNumber(int[] nums) {

        int total = 0;
        int uniqueTotal = 0;
        for (int value : nums) {
            total += value;
            set.add(value);
        }

        Iterator it = set.iterator();
        while(it.hasNext()) {
            int value = (int) it.next();
            uniqueTotal += value;
        }

        return 2 * uniqueTotal - total;
    }

    public void solve() {
        int[] input = {4, 1, 2, 1, 2};

        System.out.println(singleNumber(input));
    }
}
