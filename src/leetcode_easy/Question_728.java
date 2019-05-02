package leetcode_easy;

import java.util.ArrayList;
import java.util.List;

public class Question_728 {


    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> ans = new ArrayList<>();

        while (left <= right) {
            int target = left;

            boolean isSelfDivide = true;
            while (target  > 0) {
                int remain = target % 10;
                if (remain == 0 || left % remain != 0) {
                    isSelfDivide = false;
                    break;
                }
                target /= 10;
            }
            if (isSelfDivide) {
                ans.add(left);
            }
            left++;
        }

        return ans;
    }


    public void solve() {

        List<Integer> ans = selfDividingNumbers(1, 22);
        for (int i : ans) {
            System.out.print(i + ",");
        }

    }
}
