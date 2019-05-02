package leetcode_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Question_202 {

    HashSet<Integer> numSet = new HashSet<>();

    int[] digits = null;
    int[] buckets = null;

    private void dfs(int step) {
        if (step == buckets.length) {
            int value = 0;
            for (int val : buckets) {
                value = value * 10 + val;
            }
            numSet.add(value);
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > 0) {
                digits[i]--;
                buckets[step] = i;
                dfs(step + 1);
                digits[i]++;
            }
        }
    }

    private void numberToDigits(int n) {
        int count = 0;
        digits = new int[10];
        while (n > 0) {
            digits[n % 10]++;
            n /= 10;
            count++;
        }
        buckets = new int[count];
    }

    private int squareDigit(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    private void saveToSet(int n) {
        numberToDigits(n);
        //dfs(0);
    }

    public boolean isHappy(int n) {

        int squareSum = 0;
        do {
            squareSum = squareDigit(n);
            if (squareSum == 1) {
                return true;
            } else {
                if (numSet.contains(squareSum)) {
                    return false;
                }
                saveToSet(squareSum);
            }
            n = squareSum;
        } while (squareSum != 1);
        return false;
    }

    public void solve() {
        System.out.println(isHappy(536));
    }


}
