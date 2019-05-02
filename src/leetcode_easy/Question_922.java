package leetcode_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Question_922 {

    public int[] sortArrayByParityII(int[] A) {
        Stack oddSt = new Stack();
        Stack evenSt = new Stack();

        int[] ans = new int[A.length];

        int index = 0;
        for (int value : A) {
            if (value % 2 == 0) {
                evenSt.push(value);
            } else {
                oddSt.push(value);
            }
        }

        while (index < A.length) {
            if (index % 2 == 0) {
                ans[index] = (int) evenSt.pop();
            } else {
                ans[index] = (int) oddSt.pop();
            }
            index++;
        }

        return ans;
    }

    public int[] sortArrayByParityII2(int[] A) {
        int[] ans = new int[A.length];
        int[] odds = new int[A.length / 2];

        int normal_index = 0;
        int even_index = 0;
        for (int value : A) {
            if (value % 2 == 0) {
                ans[even_index] = value;
                even_index += 2;
            } else {
                odds[normal_index] = value;
                normal_index++;
            }
        }

        int odd_index = 1;
        for (int value : odds) {
            ans[odd_index] = value;
            odd_index += 2;
        }
        return ans;
    }

    public void solve() {
        int[] input = new int[] {4,2,5,7};
        System.out.println(Arrays.toString(sortArrayByParityII2(input)));
    }
}
