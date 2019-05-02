package EasyAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SoociiExamQ2 {

    int[] bucket = new int[10];
    int[] slot = new int[4];
    int max_time = 0;

    private void dfs(int step) {
        if (step == 4) {
            int total = 1000 * slot[0] + 100 * slot[1] + 10 * slot[2] + slot[3];
            if (total < 2359) {
                if (max_time < total) {
                    max_time = total;
                }
            }
            return;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > 0) {
                bucket[i]--;
                slot[step] = i;
                dfs(step + 1);
                bucket[i]++;
            }
        }

    }

    private String solution2(int A, int B, int C, int D) {
        int[] digits = new int[4];
        digits[0] = A;
        digits[1] = B;
        digits[2] = C;
        digits[3] = D;

        for (int digit : digits) {
            bucket[digit]++;
        }

        dfs(0);

        int index = 0;
        while(max_time > 0) {
            int digit = max_time % 10;
            digits[index] = digit;
            max_time /= 10;
            index++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(digits[3]);
        sb.append(digits[2]);
        sb.append(":");
        sb.append(digits[1]);
        sb.append(digits[0]);


        return sb.toString();
    }


    private String solution(int A, int B, int C, int D) {
        int[] digits = new int[4];
        digits[0] = A;
        digits[1] = B;
        digits[2] = C;
        digits[3] = D;
        int[] bucket = new int[10];

        for (int digit : digits) {
            bucket[digit]++;
        }

        StringBuilder sb = new StringBuilder();

        // First bit 0 - 2
        int first_bit = -1;
        for (int i = 2; i >= 0; i--) {
            if (bucket[i] > 0) {
                first_bit = i;
                bucket[i]--;
                break;
            }
        }
        if (first_bit < 0) {
            return "not possible";
        }
        sb.append(first_bit);

        int second_bit = -1;
        int second_bit_max_value = (first_bit > 1) ? 4 : 9;
        for (int i = second_bit_max_value; i >= 0; i--) {
            if (bucket[i] > 0) {
                second_bit = i;
                bucket[i]--;
                break;
            }
        }
        if (second_bit < 0) {
            return "not possible";
        }
        sb.append(second_bit);

        int third_bit = -1;
        int third_bit_max_value = 5;
        for (int i = third_bit_max_value; i >= 0; i--) {
            if (bucket[i] > 0) {
                third_bit = i;
                bucket[i]--;
                break;
            }
        }
        if (third_bit < 0) {
            return "not possible";
        }
        sb.append(":");
        sb.append(third_bit);

        int four_bit = -1;
        for (int i = 9; i >= 0; i--) {
            if (bucket[i] > 0) {
                four_bit = i;
                bucket[i]--;
                break;
            }
        }
        if (four_bit < 0) {
            return "not possible";
        }
        sb.append(four_bit);

        return sb.toString();
    }

    public void solve() {
        String time = solution2(1, 2, 3, 4);
        System.out.println(time);
    }
}
