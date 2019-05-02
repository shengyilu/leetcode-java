package leetcode_easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question_893 {


    public int numSpecialEquivGroups(String[] A) {

        Set<String> group = new HashSet<>();
        for (String str : A) {
            int[] bucket = new int[52];
            for (int i = 0; i < str.length(); i++) {
                bucket[str.charAt(i) - 'a' + 26 * (i % 2)]++;
            }
            group.add(Arrays.toString(bucket));
        }
        return group.size();
    }

    public void solve() {
        String[] input = {"abc","acb","bac","bca","cab","cba"};
        System.out.println(numSpecialEquivGroups(input));

    }
}
