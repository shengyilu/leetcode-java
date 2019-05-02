package leetcode_easy;

import java.util.ArrayList;

public class Question_657 {

    public boolean judgeCircle(String moves) {
        int y_axis_distance = 0;
        int x_axis_distance = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'u' || c == 'U') {
                y_axis_distance++;
            } else if (c == 'c' || c == 'D') {
                y_axis_distance--;
            } else if (c == 'l' || c == 'L') {
                x_axis_distance--;
            } else if (c == 'r' || c == 'R') {
                x_axis_distance++;
            }
        }

        return (y_axis_distance | x_axis_distance) == 0;
    }
}
