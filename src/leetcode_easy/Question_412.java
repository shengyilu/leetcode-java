package leetcode_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_412 {

    public List<String> fizzBuzz(int n) {

        String[] answer = new String[n];

        if (n < 3) {
            for (int i = 0; i < n; i++) {
                answer[i] = String.valueOf(i + 1);
            }
        }

        int fizzMultiple = 1;
        int fizzIndex = 2;
        while (fizzIndex < n) {
            if (fizzIndex % 15 != 0) {
                answer[fizzIndex] = "Fizz";
            }
            for (int i = 1; i <= 2; i++) {
                answer[fizzIndex - i] = String.valueOf(fizzIndex - i + 1);
            }

            if ((n -1) - fizzIndex < 3) {
                for (int i = fizzIndex + 1; i < n; i++) {
                    answer[i] = String.valueOf(i + 1);
                }
            }

            fizzMultiple++;
            fizzIndex = (fizzMultiple * 3) - 1;
        }

        int buzzMultiple = 1;
        int buzzIndex = 4;
        while (buzzIndex < n) {
            if (buzzIndex % 15 != 0) {
                answer[buzzIndex] = "Buzz";
            }

            buzzMultiple++;
            buzzIndex = (buzzMultiple * 5) - 1;
        }

        int fizzBuzzMultiple = 1;
        int fizzBuzzIndex = 14;
        while (fizzBuzzIndex < n) {
            answer[fizzBuzzIndex] = "FizzBuzz";
            fizzBuzzMultiple++;
            fizzBuzzIndex = (fizzBuzzMultiple * 15) - 1;
        }

        return Arrays.asList(answer);
    }

    public void solve() {

        List<String> result = fizzBuzz(1);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
