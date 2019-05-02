package leetcode_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        Integer[] upperLevel = null;
        for (int i = 1; i <= numRows; i++) {
            Integer[] layer = null;
            if (upperLevel == null) {
                layer = new Integer[]{1};
                upperLevel = layer;
            } else {
                layer = new Integer[i];
                for (int j = 0; j < i; j++) {
                    if (j == 0 || j == i -1) {
                        layer[j] = 1;
                    } else {
                        layer[j] = upperLevel[j] + upperLevel[j-1];
                    }
                }
                upperLevel = layer;
            }
            result.add(Arrays.asList(upperLevel));
        }
        return result;
    }

    public void solve() {

        List<List<Integer>> result = generate(5);

        for (List<Integer> array : result) {
            System.out.println(array);
        }

    }
}
