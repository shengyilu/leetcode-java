package leetcode_easy;

import java.util.Arrays;

public class Question_682 {

    private int searchBackward(String[] ops, int index) {
        int validValue = 0;
        int backward = 1;
        int searchCount = 0;
        while (index - backward >= 0) {
            if (ops[index - backward].equals("/")) {
                backward++;
                continue;
            }
            validValue += Integer.parseInt(ops[index - backward]);
            searchCount++;
            if (ops[index].equals("C")) {
                ops[index] = "/";
                ops[index - backward] = "/";
            } else if (ops[index].equals("+")) {
                if (searchCount < 2) {
                    backward++;
                    continue;
                }
            }

            break;
        }
        return validValue;
    }

    private int searchBackward(String[] ops, int index, int number_count) {
        int validValue = 0;
        int backward = 1;
        int numberCount = 0;
        while (index - backward >= 0) {
            if (ops[index - backward].equals("/")) {
                backward++;
                continue;
            }
            validValue += Integer.parseInt(ops[index - backward]);
            if (ops[index].equals("C")) {
                ops[index] = "/";
                ops[index - backward] = "/";
            }
            numberCount++;

            if (number_count == numberCount) {
                break;
            }
            backward++;
        }
        return validValue;
    }

    public int calPoints(String[] ops) {
        int totalPoint = 0;
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "C": {
                    int value = searchBackward(ops, i);
                    totalPoint -= value;
                    ops[i] = "/";
                    break;
                }
                case "D": {
                    int value = searchBackward(ops, i);
                    totalPoint += 2 * value;
                    ops[i] = String.valueOf(2 * value);
                    break;
                }
                case "+": {
                    int value = searchBackward(ops, i);
                    totalPoint = totalPoint + value;
                    ops[i] = String.valueOf(value);
                    break;
                }
                default: {
                    try {
                        int value = Integer.parseInt(ops[i]);
                        totalPoint += value;
                    } catch (NumberFormatException e) {
                        ops[i] = "/";
                    }
                    break;
                }
            }
        }
        return totalPoint;
    }

    public void solve() {
        String[] points = {"36","28","70","65","C","+","33","-46","84","C"};
        System.out.println(calPoints(points));

    }
}
